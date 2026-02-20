package com.oja.ruralCanarias.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    // CONSTRUCTORES
    public BookingActivity() {}

    public BookingActivity(Long id, Booking booking, Activity activity, LocalDateTime activityDate, Integer peopleCount, BigDecimal price) {
        this.id = id;
        this.booking = booking;
        this.activity = activity;
        this.activityDate = activityDate;
        this.peopleCount = peopleCount;
        this.price = price;
    }

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public Activity getActivity() { return activity; }
    public void setActivity(Activity activity) { this.activity = activity; }

    public LocalDateTime getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDateTime activityDate) { this.activityDate = activityDate; }

    public Integer getPeopleCount() { return peopleCount; }
    public void setPeopleCount(Integer peopleCount) { this.peopleCount = peopleCount; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
