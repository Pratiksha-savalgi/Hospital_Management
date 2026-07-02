package com.project2.PatientManagement.security;

import com.project2.PatientManagement.Entity.User;
import com.project2.PatientManagement.Repository.UserRepository;
import com.project2.PatientManagement.dto.LoginReqDto;
import com.project2.PatientManagement.dto.LoginResDto;
import com.project2.PatientManagement.dto.SignupResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public LoginResDto login(LoginReqDto loginReqDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword())
        );

    User user= (User)authentication.getPrincipal();
    String token=authUtil.generateAccessToken(user);
    return new LoginResDto(token,user.getId());

    }

    public SignupResDto signup(LoginReqDto signupReqDto) {
        User user= userRepository.findByUsername(signupReqDto.getUsername()).orElse(null);
        if(user!=null){
            throw new IllegalArgumentException("User already exists");

        }
        user=userRepository.save(User.builder()
                .username(signupReqDto.getUsername())
                .password(passwordEncoder.encode(signupReqDto.getPassword()))
                .build()
        );
       return new SignupResDto(user.getId(),user.getUsername());
    }
}
