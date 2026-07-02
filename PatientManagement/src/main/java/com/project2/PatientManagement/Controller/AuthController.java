package com.project2.PatientManagement.Controller;

import com.project2.PatientManagement.Service.UserService;
import com.project2.PatientManagement.dto.LoginReqDto;
import com.project2.PatientManagement.dto.LoginResDto;
import com.project2.PatientManagement.dto.SignupResDto;
import com.project2.PatientManagement.dto.UserResDto;
import com.project2.PatientManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

     private final AuthService authService;
     @PostMapping("/login")
    public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto loginReqDto){
         return ResponseEntity.ok(authService.login(loginReqDto));

    }
    @PostMapping("/signup")
    public ResponseEntity<SignupResDto> signup(@RequestBody LoginReqDto signupReqDto){
        return ResponseEntity.ok(authService.signup(signupReqDto));

    }

}
