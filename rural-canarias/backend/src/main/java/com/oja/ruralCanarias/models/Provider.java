package com.oja.ruralCanarias.models;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider{
    @Id
    private Long userId; 

    @OneToOne
    @MapsId
    @JoinColumn(name  ="user_id")
    private User user; 

    @Column(name = "company_name")
    private String companyName; 

    @Column(name = "contac_info")
    private String contactInfo; 

    //CONSTRUCTORES

    public Provider() {}

    public Provider(Long userId, User user, String companyName, String contactInfo) {
        this.userId = userId;
        this.user = user;
        this.companyName = companyName;
        this.contactInfo = contactInfo;
    }

    // GETTERS Y SETTERS
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

}