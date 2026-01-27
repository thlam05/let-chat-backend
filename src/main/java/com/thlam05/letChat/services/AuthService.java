package com.thlam05.letChat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thlam05.letChat.dtos.responses.LoginResponse;
import com.thlam05.letChat.enums.ResponseCode;
import com.thlam05.letChat.exceptions.AppException;
import com.thlam05.letChat.models.User;
import com.thlam05.letChat.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public LoginResponse handleLogin(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ResponseCode.BAD_LOGIN_REQUEST));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(password, user.getPassword());

        if (!authenticated)
            throw new AppException(ResponseCode.BAD_LOGIN_REQUEST);

        return LoginResponse.builder()
                .authenticated(authenticated)
                .token(password)
                .build();
    }
}
