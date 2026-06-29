package com.project2.PatientManagement.Repository;

import com.project2.PatientManagement.Entity.Appointment;
import com.project2.PatientManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
}