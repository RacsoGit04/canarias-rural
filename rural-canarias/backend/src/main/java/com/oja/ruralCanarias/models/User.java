package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false, unique = true)
    private String email; 

    @Column(name = "password_hash", nullable=false)
    private String password; 

    @Column(name="first_name")
    private String firstName; 

    @Column(name="last_name")
    private String lastName; 

    private String phone; 

    @Column(name = "is_active")
    private Boolean isActive = true; 

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumns(name="user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles = new HashSet<>(); 

    //Si es proveedor
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Provider providerProfile; 

    
}