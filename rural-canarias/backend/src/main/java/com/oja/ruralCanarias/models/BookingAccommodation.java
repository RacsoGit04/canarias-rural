package com.oja.ruralCanarias.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings_accommodations")
public class BookingAccommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "accomodation_id", nullable = false)
    private Accommodation accommodation; 

    @Column(name = "start_date")
    private LocalDate startDate; 

    @Column(name= "end_date")
    private LocalDate endDate; 

    private BigDecimal price; 
}