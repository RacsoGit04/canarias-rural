package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; 

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation; 

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity; 

    private Integer rating; 
    private String comment; 
}