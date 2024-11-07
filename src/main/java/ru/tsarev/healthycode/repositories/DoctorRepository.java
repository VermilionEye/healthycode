package ru.tsarev.healthycode.repositories;

import ru.tsarev.healthycode.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
