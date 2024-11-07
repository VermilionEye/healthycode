package ru.tsarev.healthycode.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.tsarev.healthycode.entities.Appointment;
import ru.tsarev.healthycode.entities.User;
import ru.tsarev.healthycode.repositories.AppointmentRepository;
import ru.tsarev.healthycode.security.CustomUserDetails;
import ru.tsarev.healthycode.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tsarev.healthycode.services.UserService;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private UserService userService;

    @GetMapping("/appointment")
    public String NewAppointment(Model model) {
        return "appointment";
    }

    @PostMapping("/appointment/newapp")
    public String addNewAppointment(@RequestParam String name,
                                    @RequestParam String doctorId,
                                    @RequestParam String date,
                                    @RequestParam String phone,
                                    @RequestParam String description,
                                    @RequestParam String specialty,
                                    @AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    Model model) {
        Long id = customUserDetails.getUser().getId();
        Appointment appointment = new Appointment(name, doctorId, date, phone, description, specialty, id);
        appointmentRepository.save(appointment);
        return "appointment";
    }

    @GetMapping("/allAppointments")
    public String allAppointments(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long id = customUserDetails.getUser().getId();
        Iterable<Appointment> appointments = appointmentService.getAppointmentsByUser(id);
        model.addAttribute("appointments", appointments);
        model.addAttribute("user", userService.findUserById(id));
        return "allAppointments";
    }


    //@GetMapping("/allAppointments")
    //public String allAppointments(Long userId, Model model) {
    //    Iterable<Appointment> appointments = appointmentRepository.findAll();
    //    model.addAttribute("appointments", appointments);
    //    return "allAppointments";
    //}

}