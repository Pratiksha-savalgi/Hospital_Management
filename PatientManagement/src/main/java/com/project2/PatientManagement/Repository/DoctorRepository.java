package com.project2.PatientManagement.Repository;

import com.project2.PatientManagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   Doctor findByName(String name);

    List<Doctor> findByAvailableTrue();
}