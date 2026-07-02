package com.project2.PatientManagement.dto;

import com.project2.PatientManagement.Entity.Type.Role;
import lombok.Data;

@Data
public class UserResDto {

    private Long id;

    private String username;

    private String email;

    private Role role;

    private Boolean enabled;
}