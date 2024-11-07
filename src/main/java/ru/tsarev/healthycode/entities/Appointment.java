package ru.tsarev.healthycode.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String doctor_id;
    private String date;
    private String description;
    private String phone;
    private String specialty;
    @ManyToMany(mappedBy = "appointments")
    private List<User> users;
    @Column(name = "userid")
    private Long userId;


    public Appointment(String user_name, String doctorId, String date, String phone, String description, String specialty, Long user_id) {
        this.user_name = user_name;
        this.doctor_id = doctorId;
        this.date = date;
        this.phone = phone;
        this.description = description;
        this.specialty = specialty;
        this.userId = user_id;
    }

    public Appointment() {
    }
}