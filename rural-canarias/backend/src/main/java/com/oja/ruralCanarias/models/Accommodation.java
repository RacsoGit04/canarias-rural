package com.oja.ruralCanarias.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accommodatoins")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name="provider_id", nullable = false)
    private User provider; 

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone; 

    private String name; 
    private String description; 
    private String address; 

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight; 

    private Integer capacity; 

    @Column(name = "is_active")
    private Boolean isActive = true; 

    // CONSTRUCTORES
    public Accommodation() {}

    public Accommodation(Long id, User provider, Zone zone, String name, String description, String address, BigDecimal pricePerNight, Integer capacity, Boolean isActive) {
        this.id = id;
        this.provider = provider;
        this.zone = zone;
        this.name = name;
        this.description = description;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
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

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public BigDecimal getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }


}

