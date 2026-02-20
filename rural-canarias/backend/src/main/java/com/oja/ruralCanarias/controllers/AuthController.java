package com.oja.ruralCanarias.controllers;

import com.oja.ruralCanarias.dtos.user.RegisterRequest;
import com.oja.ruralCanarias.dtos.user.RegisterResponse;
import com.oja.ruralCanarias.dtos.user.ErrorResponse;

import com.oja.ruralCanarias.services.AuthService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService; 

    @PostMapping("/register")
    // <?> podemos devolver un RegisterResponse (si va bien) o un Map (si hay error)
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){ 
        try {
            RegisterResponse response = authService.registerUser(request); 
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response); 
            
        } catch (RuntimeException e) {
            ErrorResponse miError = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(miError); 
        }
    }
}