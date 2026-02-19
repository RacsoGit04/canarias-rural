package com.oja.ruralCanarias.models;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;

@Entity
@Table(name="roles")

public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false, unique = true)
    private String name; 

    private String description; 
}
