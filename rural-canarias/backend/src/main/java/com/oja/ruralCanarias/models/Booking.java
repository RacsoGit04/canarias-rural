package com.oja.ruralCanarias.models;

import java.lang.annotation.Inherited;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Lond id; 

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    private String status = "PENDING"; 

    @Column(name = "total_price")
    private BigDecimal totalPrice; 

    @Column(name = "created_at")
    private LocalDateTime createdAt; 
}