package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.RegisterUser;
import com.example.demo.entity.User;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(RegisterUser input) {
        User user = new User();
                user.setName(input.name());
                user.setEmail(input.email());
                user.setPassword(passwordEncoder.encode(input.password()));

        return userRepo.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepo.findByEmail(input.email())
                .orElseThrow();
    }
}