package com.project2.PatientManagement.Entity.Service;

import com.project2.PatientManagement.Entity.Appointment;
import com.project2.PatientManagement.Entity.Doctor;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Repository.AppointmentRepository;
import com.project2.PatientManagement.Repository.DoctorRepository;
import com.project2.PatientManagement.Repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;
    public void createNewAppointment(Appointment appointment, Long doctorId,Long patiendId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepo.findById(patiendId).orElseThrow();
        if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment should not have id");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

    }
}
