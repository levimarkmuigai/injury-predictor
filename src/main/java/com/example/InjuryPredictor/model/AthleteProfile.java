package com.example.InjuryPredictor.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

import java.math.BigDecimal;

import java.util.List;

@Entity
@Table(name = "Athlete_Profile")
public class AthleteProfile{
    
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

    @Column(name="Weight", nullable=false)
    @NotNull(message="Weight cannot be null!")
    @Positive
    private BigDecimal weight;

    @Column(name="Height", nullable=false)
    @NotNull(message="Height cannot be null!")
    @Positive
    private BigDecimal height;

    @OneToMany(
        mappedBy = "athleteProfile",
        cascade =   CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<PredictionRecord> predictionRecord;

    private String recommendations;

    public AthleteProfile(){}

    public AthleteProfile(Long id, String firstName, String lastName, LocalDate dob,
            String gender, LocalDate registrationDate, BigDecimal weight, BigDecimal height,
            List<PredictionRecord> predictionRecord, String recommendations){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.registrationDate = registrationDate;
        this.weight = weight;
        this.height = height;
        this.predictionRecord = predictionRecord;
        this.recommendations = recommendations;
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

    public LocalDate getRegistrationDate(){
        return this.registrationDate;
    }

    public BigDecimal getWeight(){
        return this.weight;
    }

    public BigDecimal getHeight(){
        return this.height;
    }

    public List<PredictionRecord> getPredictions(){
        return this.predictionRecord;
    }

    public String getRecommendations(){
        return this.recommendations;
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

    public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }

     public void setWeight(BigDecimal weight){
        this.weight = weight;
    }

    public void setHeight(BigDecimal height){
        this.height = height;
    }

    public void setPredictions(List<PredictionRecord> predictionRecord){
        this.predictionRecord = predictionRecord;
    } 

    public void setRecommendations(String recommendations){
        this.recommendations = recommendations;
    }
}
