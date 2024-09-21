package com.oleksiyk.lift_and_shift.controller;

import com.oleksiyk.lift_and_shift.model.AuthRequest;
import com.oleksiyk.lift_and_shift.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request, HttpServletResponse response) {
        String token = authService.loginUser(request.getEmail(), request.getPassword());

        Cookie jwtCookie = new Cookie("token", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(false); //set to true when using https
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(3 * 60 * 60); //expires in 3 hours

        response.addCookie(jwtCookie);

        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        authService.registerUser(request.getEmail(), request.getPassword());
        return "Success!";
    }
}
