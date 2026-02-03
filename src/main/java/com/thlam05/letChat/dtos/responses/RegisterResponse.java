package com.thlam05.letchat.dtos.responses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegisterResponse {
    private String id;
    private String username;
    private String description;
    private LocalDateTime createdAt;
}
