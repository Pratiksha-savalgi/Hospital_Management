package com.project2.PatientManagement;

import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Entity.Type.bloodType;
import com.project2.PatientManagement.Repository.PatientRepo;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
@SpringBootTest

public class test {
    @Autowired
    private PatientRepo patientRepo;

    @Test

    public void patienttest() {
//       List<Patient> patientList= patientRepo.findAll();
//       System.out.println(patientList);
//       System.out.println(patientRepo.findByName("Dev"));

//        Page<Patient> patientList1 = patientRepo.findAllPatients(PageRequest.of(0,3, Sort.by("name")));
//        for (Patient patient : patientList1) {
//            System.out.println(patient);}
//            List<Object[]> pl = patientRepo.CountEachBloodGroupType();
//            for (Object[] obj : pl) {
//                System.out.println(obj[0] + " " + obj[1]);
//
//
//            }


//        int rowsUpdated=patientRepo.updateNameWithId("Dev Dixit", 2L);
//        System.out.println(rowsUpdated);
    }
}