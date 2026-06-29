package com.project2.PatientManagement.Service;

import com.project2.PatientManagement.Entity.Appointment;
import com.project2.PatientManagement.Entity.Doctor;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Entity.Type.AppointmentStatus;
import com.project2.PatientManagement.Repository.AppointmentRepository;
import com.project2.PatientManagement.Repository.DoctorRepository;
import com.project2.PatientManagement.Repository.PatientRepo;
import com.project2.PatientManagement.dto.AppReqDto;
import com.project2.PatientManagement.dto.AppResDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    public AppResDto createAppointment(AppReqDto appReqDto) {

        Patient patient = patientRepo.findById(appReqDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appReqDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(appReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appReqDto.getAppointmentTime());
        appointment.setReason(appReqDto.getReason());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus(AppointmentStatus.SCHEDULED);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppResDto appResDto = modelMapper.map(savedAppointment, AppResDto.class);

        appResDto.setPatientName(savedAppointment.getPatient().getName());
        appResDto.setDoctorName(savedAppointment.getDoctor().getName());
        appResDto.setDoctorSpecialization(savedAppointment.getDoctor().getSpecialization());

        return appResDto;
    }

    public AppResDto getAppointmentById(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        AppResDto appResDto = modelMapper.map(appointment, AppResDto.class);

        appResDto.setPatientName(appointment.getPatient().getName());
        appResDto.setDoctorName(appointment.getDoctor().getName());
        appResDto.setDoctorSpecialization(appointment.getDoctor().getSpecialization());

        return appResDto;
    }
    public List<AppResDto> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> {
                    AppResDto dto = modelMapper.map(appointment, AppResDto.class);

                    dto.setPatientName(appointment.getPatient().getName());
                    dto.setDoctorName(appointment.getDoctor().getName());
                    dto.setDoctorSpecialization(appointment.getDoctor().getSpecialization());

                    return dto;
                })
                .toList();
    }
    public AppResDto updateAppointment(Long id, AppReqDto appReqDto) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Patient patient = patientRepo.findById(appReqDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appReqDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setAppointmentDate(appReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appReqDto.getAppointmentTime());
        appointment.setReason(appReqDto.getReason());


        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment updated = appointmentRepository.save(appointment);

        AppResDto dto = modelMapper.map(updated, AppResDto.class);

        dto.setPatientName(updated.getPatient().getName());
        dto.setDoctorName(updated.getDoctor().getName());
        dto.setDoctorSpecialization(updated.getDoctor().getSpecialization());

        return dto;
    }
    public void deleteAppointment(Long id) {

        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }

        appointmentRepository.deleteById(id);
    }

    public List<AppResDto> getAppointmentsByPatient(Long patientId) {

        return appointmentRepository.findByPatientId(patientId)
                .stream()
                .map(appointment -> {
                    AppResDto dto = modelMapper.map(appointment, AppResDto.class);

                    dto.setPatientName(appointment.getPatient().getName());
                    dto.setDoctorName(appointment.getDoctor().getName());
                    dto.setDoctorSpecialization(appointment.getDoctor().getSpecialization());

                    return dto;
                })
                .toList();
    }
    public List<AppResDto> getAppointmentsByDoctor(Long doctorId) {

        return appointmentRepository.findByDoctorId(doctorId)
                .stream()
                .map(appointment -> {
                    AppResDto dto = modelMapper.map(appointment, AppResDto.class);

                    dto.setPatientName(appointment.getPatient().getName());
                    dto.setDoctorName(appointment.getDoctor().getName());
                    dto.setDoctorSpecialization(appointment.getDoctor().getSpecialization());

                    return dto;
                })
                .toList();
    }
}
