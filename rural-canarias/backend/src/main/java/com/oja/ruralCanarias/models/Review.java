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

    // CONSTRUCTORES
    public Review() {}

    public Review(Long id, User user, Accommodation accommodation, Activity activity, Integer rating, String comment) {
        this.id = id;
        this.user = user;
        this.accommodation = accommodation;
        this.activity = activity;
        this.rating = rating;
        this.comment = comment;
    }

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Accommodation getAccommodation() { return accommodation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }

    public Activity getActivity() { return activity; }
    public void setActivity(Activity activity) { this.activity = activity; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}