package com.oja.ruralCanarias.models;

import java.lang.annotation.Inherited;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodatoins")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name="provider_id", nullable = false)
    private User provider; 

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone; 

    private String name; 
    private String description; 
    private String address; 

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight; 

    private Integer capacity; 

    @Column(name = "is_active")
    private Boolean isActive = true; 
}

// CONSTRUCTORES

// GETTERS Y SETTERS