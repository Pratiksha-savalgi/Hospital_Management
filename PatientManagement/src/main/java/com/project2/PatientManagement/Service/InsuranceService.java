package com.project2.PatientManagement.Service;

import com.project2.PatientManagement.Entity.Insurance;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Repository.InsuranceRepository;
import com.project2.PatientManagement.Repository.PatientRepo;
import com.project2.PatientManagement.dto.InsReqdto;
import com.project2.PatientManagement.dto.InsResdto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepo patientRepo;
    private final ModelMapper modelmapper;
    @Transactional
    public InsResdto createNewInsurance(Long patientId,InsReqdto insReqdto){
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with id"));
        Insurance insurance=modelmapper.map(insReqdto,Insurance.class);
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency
        patientRepo.save(patient);
        return modelmapper.map(insurance, InsResdto.class);


    }


    public List<InsResdto> getAllInsurances() {
        List<Insurance> insurances = insuranceRepository.findAll();
        return insurances.stream()
                .map(insurance -> modelmapper.map(insurance, InsResdto.class))
                .toList();

    }

    public InsResdto updateInsurance(Long id, InsReqdto insReqdto) {
        Patient patient= patientRepo.findById(id).orElseThrow();
        Insurance insurance= patient.getInsurance();
        if (insurance == null) {
            throw new RuntimeException("Patient has no insurance");
        }
        modelmapper.map(insReqdto,insurance);
        insuranceRepository.save(insurance);
        return modelmapper.map(insurance, InsResdto.class);

    }

    public void deleteInsurance(long pid) {
        Patient patient = patientRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Patient not found"));
        Insurance insurance=patient.getInsurance();
        if(insurance==null){
            throw new RuntimeException("Patient has no insurance you cannot delete");

        }
        patient.setInsurance(null);
        insurance.setPatient(null);

        patientRepo.save(patient);
        insuranceRepository.deleteById(insurance.getId());
    }
}
