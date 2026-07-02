package com.project2.PatientManagement.Controller;

import com.project2.PatientManagement.Service.DoctorService;
import com.project2.PatientManagement.Service.PatientService;
import com.project2.PatientManagement.dto.DoctorResDto;
import com.project2.PatientManagement.dto.PatientRequestDTO;
import com.project2.PatientManagement.dto.PatientResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/patient")
public class PatientController {

    private final PatientService patientService;
    private final DoctorService doctorService;
    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> CreateNewPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createNewPatient(patientRequestDTO));
    }

    @GetMapping("/get")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<PatientResponseDTO> getByName(@PathVariable String name){
        return ResponseEntity.ok(patientService.getByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatients(@PathVariable Long id ,@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok(patientService.updatePatients(id,patientRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/available-doctors")
    public ResponseEntity<List<DoctorResDto>> getAvailableDoctors() {
        return ResponseEntity.ok(doctorService.getAvailableDoctors());
    }

}
