package com.project2.PatientManagement.dto;
import com.project2.PatientManagement.Entity.Type.bloodType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDTO {

    private Long id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private bloodType bloodGroup;
}