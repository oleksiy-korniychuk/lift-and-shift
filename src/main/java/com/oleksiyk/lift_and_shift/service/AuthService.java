package com.oleksiyk.lift_and_shift.service;

import com.oleksiyk.lift_and_shift.entity.User;
import com.oleksiyk.lift_and_shift.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        return generateJwtToken(user);
    }

    private String generateJwtToken(User user) {
        SecretKey key = Keys.hmacShaKeyFor("test66666666666666666666666666666".getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) //1 day
                .signWith(key)
                .compact();
    }
}
