package com.example.injury_predictor.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class athlete_profile{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id", nullable = false)
    @Size(max=25, message="First name cannot exceed 25 characters!")
    private Long id;

    @Column(name="firstname", nullable=false)
    @NotNull(message="First name cannot be null!")
    private String firstName;

    @Column(name="lastname", nullable=false)
    @NotNull(message="Last name cannot be null!")
    @Size(max=25, message="Last name cannot exceed 25 characters")
    private String lastName;

    @Column(name="Date of Birth", nullable=false)
    @Past
    @NotNull(message="DOB cannot be null!")
    private LocalDate dob;

    @Column(name="gender", nullable=false)
    @NotNull(message="Gender cannot be empty!")
    @Size(max=8)
    private String gender;

    @Column(name="Registration Date", nullable=false)
    @NotNull(message="Registration date cannot be null!")
    private LocalDate registrationDate;

    public athlete_profile(){}

    public athlete_profile(Long id, String firstName, String lastName, LocalDate dob,
            String gender, LocalDate registrationDate){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.registrationDate = registrationDate;
    }

    // Getters
    public Long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public LocalDate getDob(){
        return this.dob;
    }

    public String getGender(){
        return this.gender;
    }

    public LocalDate getRegistriationDate(){
        return this.registrationDate;
    }

    // Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void getRegistriationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }
}
