package com.project2.PatientManagement.Entity.Service;

import com.project2.PatientManagement.Entity.Insurance;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Repository.InsuranceRepository;
import com.project2.PatientManagement.Repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepo patientRepo;
    @Transactional
    public Patient assignInsuranceToPatients(Insurance insurance,Long patientId){
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with id"));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency
        return patient;


    }
}
