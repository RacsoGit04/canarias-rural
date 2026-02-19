package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name; 
    private String island; 
    private String description; 
}

