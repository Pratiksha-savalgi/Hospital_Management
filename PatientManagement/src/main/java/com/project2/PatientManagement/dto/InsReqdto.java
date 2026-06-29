package com.project2.PatientManagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InsReqdto {

    private String policyNumber;
    private String provider;
    private LocalDate validDate;
}
