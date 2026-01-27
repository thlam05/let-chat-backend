package com.thlam05.letChat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thlam05.letChat.dtos.requests.LoginRequest;
import com.thlam05.letChat.dtos.requests.RegisterRequest;
import com.thlam05.letChat.dtos.responses.APIResponse;
import com.thlam05.letChat.dtos.responses.LoginResponse;
import com.thlam05.letChat.dtos.responses.RegisterResponse;
import com.thlam05.letChat.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public APIResponse<LoginResponse> handleLogin(@Valid @RequestBody LoginRequest request) {
        LoginResponse loginResponse = authService.handleLogin(request.getUsername(), request.getPassword());

        return new APIResponse<LoginResponse>(loginResponse);
    }

    @PostMapping("/register")
    public APIResponse<RegisterResponse> handleRegister(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse registerResponse = authService.handleRegister(request.getUsername(), request.getPassword());

        return new APIResponse<RegisterResponse>(registerResponse);
    }

}
