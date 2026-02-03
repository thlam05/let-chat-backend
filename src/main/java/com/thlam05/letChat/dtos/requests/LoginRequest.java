package com.thlam05.letchat.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank(message = "Username is required.")
    @Size(min = 6, message = "Usernames must have at least 6 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must have at least 6 characters.")
    private String password;
}
