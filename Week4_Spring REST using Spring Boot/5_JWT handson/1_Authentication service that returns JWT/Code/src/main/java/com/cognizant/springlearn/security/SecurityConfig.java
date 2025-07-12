package com.cognizant.springlearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // disable CSRF for a stateless REST API
                .csrf(csrf -> csrf.disable())

                // STEP 1: start configuring URL authorization
                .authorizeHttpRequests(auth -> auth
                        // allow unauthenticated access to /authenticate
                        .requestMatchers("/authenticate").permitAll()

                        // allow public GET endpoints if you have any
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/country", "/countries/**").permitAll()

                        // secure everything else
                        .anyRequest().authenticated()
                )

                // STEP 2: use HTTP Basic for the /authenticate endpoint
                .httpBasic(basic -> basic.disable())   // we handle Basic in our controller
                .httpBasic();

        return http.build();
    }
}

