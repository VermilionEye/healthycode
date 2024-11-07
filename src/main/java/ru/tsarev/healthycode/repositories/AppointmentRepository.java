package ru.tsarev.healthycode.repositories;

import org.springframework.stereotype.Repository;
import ru.tsarev.healthycode.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsarev.healthycode.entities.User;

import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByuserId(Long userId);
}