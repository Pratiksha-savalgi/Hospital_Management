package com.project2.PatientManagement.Controller;

import com.project2.PatientManagement.Service.DoctorService;
import com.project2.PatientManagement.dto.DoctorReqDto;
import com.project2.PatientManagement.dto.DoctorResDto;
import com.project2.PatientManagement.dto.PatientRequestDTO;
import com.project2.PatientManagement.dto.PatientResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/")
    public ResponseEntity<DoctorResDto> createDoctor(@Valid @RequestBody DoctorReqDto doctorReqDto){
        return ResponseEntity.ok(doctorService.createDoctor(doctorReqDto));
    }

    @GetMapping("/{did}")
    public ResponseEntity<DoctorResDto> getDoctorById(@PathVariable Long did){
        return ResponseEntity.ok(doctorService.getDoctorById(did));
    }

    @GetMapping("search/{name}")
    public ResponseEntity<DoctorResDto> getDoctorByName(@PathVariable String name){
        return ResponseEntity.ok(doctorService.getDoctorByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResDto> updateDoctor(@PathVariable Long id , @Valid @RequestBody DoctorReqDto doctorReqDto){
        return ResponseEntity.ok(doctorService.updateDoctor(id,doctorReqDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
