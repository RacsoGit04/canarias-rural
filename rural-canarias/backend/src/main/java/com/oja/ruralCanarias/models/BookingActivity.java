package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings_activities")
public class BookingActivity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking; 

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable=false)
    private Activity activity; 

    @Column(name = "activity_date")
    private LocalDateTime activityDate; 

    @Column(name ="people_count")
    private Integer peopleCount; 

    private BigDecimal price; 
}