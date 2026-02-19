package com.oja.ruralCanarias.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

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

    // CONSTRUCTORES 
    public Activity() {}

    public Activity(Long id, User provider, Zone zone, String name, String description, BigDecimal pricePerPerson, Integer durationMinutes, Boolean isActive) {
        this.id = id;
        this.provider = provider;
        this.zone = zone;
        this.name = name;
        this.description = description;
        this.pricePerPerson = pricePerPerson;
        this.durationMinutes = durationMinutes;
        this.isActive = isActive;
    }

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getProvider() { return provider; }
    public void setProvider(User provider) { this.provider = provider; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPricePerPerson() { return pricePerPerson; }
    public void setPricePerPerson(BigDecimal pricePerPerson) { this.pricePerPerson = pricePerPerson; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
