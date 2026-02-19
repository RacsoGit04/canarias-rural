package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name; 
    private String island; 
    private String description; 

    // CONSTRUCTORES
    public Zone() {}

    public Zone(Long id, String name, String island, String description) {
        this.id = id;
        this.name = name;
        this.island = island;
        this.description = description;
    }

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIsland() { return island; }
    public void setIsland(String island) { this.island = island; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

