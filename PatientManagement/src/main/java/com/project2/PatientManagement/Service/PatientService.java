package com.project2.PatientManagement.Service;

import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Repository.PatientRepo;
import com.project2.PatientManagement.dto.PatientRequestDTO;
import com.project2.PatientManagement.dto.PatientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    public PatientResponseDTO createNewPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = modelMapper.map(patientRequestDTO, Patient.class);
        Patient savePatient = patientRepo.save(patient);
        return modelMapper.map(savePatient, PatientResponseDTO.class);
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        return patients
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .toList();


    }

    public PatientResponseDTO getById(Long id) {
        Patient patient= patientRepo.findById(id).orElseThrow();
        return modelMapper.map(patient,PatientResponseDTO.class);
    }

    public PatientResponseDTO getByName(String name) {
        Patient patient= patientRepo.findByName(name);
        return modelMapper.map(patient,PatientResponseDTO.class);
    }

    public PatientResponseDTO updatePatients(Long id,PatientRequestDTO patientRequestDTO) {
      Patient patient=patientRepo.findById(id).orElseThrow();
      modelMapper.map(patientRequestDTO,patient);
      Patient savepatient=patientRepo.save(patient);
      return modelMapper.map(savepatient,PatientResponseDTO.class);
    }

    public void deletePatient(Long id) {
        if(!patientRepo.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id"+id);
        }
        patientRepo.deleteById(id);
    }
}
