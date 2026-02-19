package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodations_images")
public class AccommodationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation; 

    private String url; 

    @Column(name = "is_main")
    private Boolean isMain; 

    // CONSTRUCTORES 
    public AccommodationImage() {}

    public AccommodationImage(Long id, Accommodation accommodation, String url, Boolean isMain) {
        this.id = id;
        this.accommodation = accommodation;
        this.url = url;
        this.isMain = isMain;
    }

    // GETTERS Y SETTERS 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Accommodation getAccommodation() { return accommodation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Boolean getIsMain() { return isMain; }
    public void setIsMain(Boolean isMain) { this.isMain = isMain; }

}