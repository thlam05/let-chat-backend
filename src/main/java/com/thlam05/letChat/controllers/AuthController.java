package com.thlam05.letchat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;
import com.thlam05.letchat.dtos.requests.LoginRequest;
import com.thlam05.letchat.dtos.requests.RegisterRequest;
import com.thlam05.letchat.dtos.responses.APIResponse;
import com.thlam05.letchat.dtos.responses.LoginResponse;
import com.thlam05.letchat.dtos.responses.RegisterResponse;
import com.thlam05.letchat.services.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public APIResponse<LoginResponse> handleLogin(@Valid @RequestBody LoginRequest request) throws JOSEException {
        LoginResponse loginResponse = authService.handleLogin(request.getUsername(), request.getPassword());

        return new APIResponse<LoginResponse>(loginResponse);
    }

    @PostMapping("/register")
    public APIResponse<RegisterResponse> handleRegister(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse registerResponse = authService.handleRegister(request.getUsername(), request.getPassword());

        return new APIResponse<RegisterResponse>(registerResponse);
    }

}
