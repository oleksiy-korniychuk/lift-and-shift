package com.oleksiyk.lift_and_shift.service;

import com.oleksiyk.lift_and_shift.entity.User;
import com.oleksiyk.lift_and_shift.repository.UserRepository;
import com.oleksiyk.lift_and_shift.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider tokenProvider;

    public void registerUser(String email, String password) {
        userRepository.findByEmail(email).ifPresent(user -> {
            throw new IllegalStateException("User already exists");
        });
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Generate JWT
        return tokenProvider.generateToken(email);
    }
}
