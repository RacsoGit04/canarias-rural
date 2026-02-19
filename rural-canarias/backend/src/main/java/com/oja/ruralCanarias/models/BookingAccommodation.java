package com.oja.ruralCanarias.models;

import java.time.LocalDate;
import java.math.BigDecimal;
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

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "start_date")
    private LocalDate startDate; 

    @Column(name= "end_date")
    private LocalDate endDate; 

    private BigDecimal price; 

    // CONSTRUCTORES 
    public BookingAccommodation() {}

    public BookingAccommodation(Long id, Booking booking, Accommodation accommodation, LocalDate startDate, LocalDate endDate, BigDecimal price) {
        this.id = id;
        this.booking = booking;
        this.accommodation = accommodation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    // GETTERS Y SETTERS 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public Accommodation getAccommodation() { return accommodation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
