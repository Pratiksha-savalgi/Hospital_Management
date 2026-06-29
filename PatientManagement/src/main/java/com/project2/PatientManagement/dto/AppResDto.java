package com.project2.PatientManagement.dto;

import com.project2.PatientManagement.Entity.Type.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppResDto {
    private Long id;

    private String patientName;

    private String doctorName;

    private String doctorSpecialization;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String reason;

    private AppointmentStatus status;
}
