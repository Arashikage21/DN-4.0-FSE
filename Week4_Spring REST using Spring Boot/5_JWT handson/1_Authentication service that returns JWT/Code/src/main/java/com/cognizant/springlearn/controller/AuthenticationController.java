package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public TokenResponse authenticate(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        LOGGER.info(">> Start authenticate()");
        if (!StringUtils.hasText(authHeader) || !authHeader.startsWith("Basic ")) {
            throw new IllegalArgumentException("Missing or invalid Authorization header");
        }

        // 1. Decode Basic <credentials>
        String base64Creds = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Creds);
        String[] parts = new String(decoded, StandardCharsets.UTF_8).split(":", 2);

        if (parts.length != 2 || !"user".equals(parts[0]) || !"pwd".equals(parts[1])) {
            // Replace this with real user lookup in a real app
            throw new IllegalArgumentException("Invalid credentials");
        }

        // 2. Generate JWT
        String token = jwtUtil.generateToken(parts[0]);

        LOGGER.info("<< End authenticate()");
        return new TokenResponse(token);
    }

    // Simple DTO for JSON response
    public static class TokenResponse {
        private final String token;
        public TokenResponse(String token) { this.token = token; }
        public String getToken() { return token; }
    }
}
