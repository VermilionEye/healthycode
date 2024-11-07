package ru.tsarev.healthycode.services;

import ru.tsarev.healthycode.entities.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsarev.healthycode.entities.User;
import ru.tsarev.healthycode.repositories.AppointmentRepository;
import ru.tsarev.healthycode.repositories.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
       return appointmentRepository.findAppointmentByuserId(userId);
    }
}