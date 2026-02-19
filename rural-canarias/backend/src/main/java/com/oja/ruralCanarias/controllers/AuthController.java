package com.oja.ruralCanarias.controllers;

import com.oja.ruralCanarias.dtos.RegisterRequest; 
import com.oja.ruralCanarias.services.AuthService; 
import org.springframework.beans.factory.annotations.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestManpping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService; 

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequets request){
        try{
            String responseMessage = authService.registerUser(request); 
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED); 
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); 
        }
    }
}
