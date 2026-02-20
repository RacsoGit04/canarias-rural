package com.oja.ruralCanarias.dtos.user;
public class RegisterResponse {
    
    private String message;

    //CONSTRUCTORES

    public RegisterResponse() { }

    public RegisterResponse(String message) { this.message = message;}

    //GETTERS Y SETTERS

    public String getMessage() {return message;  }

    public void setMessage(String message) {  this.message = message;}
}