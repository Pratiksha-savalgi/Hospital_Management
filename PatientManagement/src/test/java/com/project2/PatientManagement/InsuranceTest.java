package com.project2.PatientManagement;

import com.project2.PatientManagement.Entity.Insurance;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Entity.Service.InsuranceService;
import com.project2.PatientManagement.Repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired

    private  InsuranceService insuranceService;
    @Test
    public void insuranceTest(){
         Insurance insurance = Insurance.builder()
                 .policyNumber("HDFC_1001")
                 .provider("HDFC")
                 .validDate(LocalDate.of(2030,12,1))
                 .build();
         Patient patient=insuranceService.assignInsuranceToPatients(insurance,1L);
         System.out.println(patient);
     }
}
