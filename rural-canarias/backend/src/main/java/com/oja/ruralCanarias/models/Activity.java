package com.oja.ruralCanarias.models;

import jakarta.persistence.*;


@Entity
@Table(name = "activities")
public class Activity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id, nullable = false")
    private User provider; 

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone; 

    private String name; 
    private String description; 

    @Column(name = "price_per_person")
    private BigDecimal pricePerPerson; 

    @Column(name = "duration_minutes")
    private Integer durationMinutes; 

    @Column(name = "is_active")
    private Boolean isActive = true; 
}