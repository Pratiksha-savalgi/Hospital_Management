package com.project2.PatientManagement.Service;

import com.project2.PatientManagement.Entity.Doctor;
import com.project2.PatientManagement.Entity.Patient;
import com.project2.PatientManagement.Repository.DoctorRepository;
import com.project2.PatientManagement.dto.DoctorReqDto;
import com.project2.PatientManagement.dto.DoctorResDto;
import com.project2.PatientManagement.dto.PatientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public DoctorResDto createDoctor(DoctorReqDto doctorReqDto) {
        Doctor doctor=modelMapper.map(doctorReqDto,Doctor.class);
        doctor.setAvailable(true);
        Doctor saveDoctor =doctorRepository.save(doctor);
        return modelMapper.map(saveDoctor, DoctorResDto.class);
    }

    public DoctorResDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return modelMapper.map(doctor,DoctorResDto.class);
    }

    public DoctorResDto getDoctorByName(String name) {
        Doctor doctor = doctorRepository.findByName(name);
        if (doctor == null) {
            throw new RuntimeException("Doctor not found");
        }
        return modelMapper.map(doctor,DoctorResDto.class);
    }


    public DoctorResDto updateDoctor(Long id, DoctorReqDto doctorReqDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        modelMapper.map(doctorReqDto,doctor);
        doctorRepository.save(doctor);
        return modelMapper.map(doctor,DoctorResDto.class);
    }

    public void deleteDoctor(Long id) {
        if(!doctorRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id"+id);
        }
        doctorRepository.deleteById(id);
    }

}
