package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodations_images")
public class AccommodationImage {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation; 

    private String url; 

    @Column(name = "is_main")
    private Boolean isMain; 

}