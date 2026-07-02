package com.project2.PatientManagement.security;

import com.project2.PatientManagement.Repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

     @Override
    public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username).orElseThrow();
    }
}
