package com.oja.ruralCanarias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http    
            .csrf(csrf -> csrf.disable()) //CSRF es un escudo contra ataques de formularios falsos
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() ///api/auth/register
                .anyRequest().authenticated()
            
            ); 
        return http.build(); 
    }
}