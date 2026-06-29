package com.project2.PatientManagement.dto;

import com.project2.PatientManagement.Entity.Type.bloodType;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientRequestDTO {
    @NotBlank(message = "Name not found")
    private String name;
    @Email
    @NotBlank(message = "Email not found")

    private String email;

    private LocalDate birthDate;

    private bloodType bloodGroup;


}
