package com.project2.PatientManagement.Controller;

import com.project2.PatientManagement.Service.AppointmentService;
import com.project2.PatientManagement.dto.AppReqDto;
import com.project2.PatientManagement.dto.AppResDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppResDto> createAppointment(
            @Valid @RequestBody AppReqDto appointmentReqDto) {

        return ResponseEntity.ok(
                appointmentService.createAppointment(appointmentReqDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResDto> getAppointmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<AppResDto>> getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppResDto>> getAppointmentsByPatient(
            @PathVariable Long patientId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByPatient(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppResDto>> getAppointmentsByDoctor(
            @PathVariable Long doctorId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDoctor(doctorId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppResDto> updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody AppReqDto appointmentReqDto) {

        return ResponseEntity.ok(
                appointmentService.updateAppointment(id, appointmentReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(
            @PathVariable Long id) {

        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
