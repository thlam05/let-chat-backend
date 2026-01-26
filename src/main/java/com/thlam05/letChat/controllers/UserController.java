package com.thlam05.letChat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getMethodName() {
        return "TEST";
    }

}
