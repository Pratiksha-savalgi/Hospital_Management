package com.project2.PatientManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsResdto {
    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDate validDate;
    private LocalDateTime created_at;


}
