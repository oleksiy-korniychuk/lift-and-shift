package com.oleksiyk.lift_and_shift.controller;

import com.oleksiyk.lift_and_shift.model.AuthRequest;
import com.oleksiyk.lift_and_shift.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authService.loginUser(request.getEmail(), request.getPassword());
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        authService.registerUser(request.getEmail(), request.getPassword());
        return "Success!";
    }
}
