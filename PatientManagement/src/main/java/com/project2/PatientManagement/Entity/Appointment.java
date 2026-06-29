package com.project2.PatientManagement.Entity;

import com.project2.PatientManagement.Entity.Type.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalTime appointmentTime;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate appointmentDate;

    @Column(length = 500)
    private String reason;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;


    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false) // every appointment should have patients
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;
}
