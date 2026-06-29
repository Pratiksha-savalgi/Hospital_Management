package com.project2.PatientManagement.Controller;

import com.project2.PatientManagement.Repository.InsuranceRepository;
import com.project2.PatientManagement.Service.InsuranceService;
import com.project2.PatientManagement.dto.InsReqdto;
import com.project2.PatientManagement.dto.InsResdto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;
    @PostMapping("/{pid}")
    public ResponseEntity<InsResdto> createInsurance(@PathVariable Long pid,@Valid @RequestBody InsReqdto insReqdto){
        return ResponseEntity.ok(insuranceService.createNewInsurance(pid,insReqdto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<InsResdto>> getAllInsurance(){
        return ResponseEntity.ok(insuranceService.getAllInsurances());
    }
    @PutMapping("update/{id}")
    public ResponseEntity<InsResdto> updateInusurance(@PathVariable Long pid, @Valid @RequestBody InsReqdto insReqdto){
        return ResponseEntity.ok(insuranceService.updateInsurance(pid,insReqdto));
    }
    @DeleteMapping("/{pid}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable long pid ){
        insuranceService.deleteInsurance(pid);
        return ResponseEntity.noContent().build();
    }
}
