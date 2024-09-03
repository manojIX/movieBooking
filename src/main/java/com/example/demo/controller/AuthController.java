package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.RegisterUser;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;

@RestController
public class AuthController {
	@Autowired
	private JwtService jwtService;
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUser registerUserDto) {
        User registeredUser = authService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        User authenticatedUser = authService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken,jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
