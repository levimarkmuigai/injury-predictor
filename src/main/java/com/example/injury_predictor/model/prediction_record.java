package com.example.injury_predictor.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

import java.time.LocalDate;

public class prediction_record{
    
    @Column(name="Id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name="athlete_prediction",
        joinColumns = @JoinColumn(name="prediction_id"),
        inverseJoinColumns = @JoinColumn(name="athlete_id")
    )
    private athlete_profile athlete_profile;

    @Column(name="Past Injuries", nullable=false)
    @NotNull(message="Past Injuries cannot be null!")
    private String pastInjuries;

    @Column(name="Risk Level", nullable=false)
    @NotNull(message="Risk level cannot be null!")
    @Size(max=10)
    private String riskLevel;

    @Column(name="Risk Score")
    @NotNull(message="Risk Score cannot be null!")
    private BigDecimal riskScore;

    @Column(name="Predicted at", nullable=false)
    @PastOrPresent
    private LocalDate predictedAt;

    public prediction_record(){}

    public prediction_record(Long id, String pastInjuries, BigDecimal riskScore,
            LocalDate predictedAt, athlete_profile athlete_profile){

        this.id = id;
        this.pastInjuries = pastInjuries;
        this.riskScore = riskScore;
        this.predictedAt = predictedAt;
        this.athlete_profile = athlete_profile;
    }

    // Getters
    public Long getId(){
        return this.id;
    }

    public String getPastInjuries(){
        return this.pastInjuries; 
    }

    public BigDecimal getRiskScore(){
        return this.riskScore;
    }

    public LocalDate getPredictedAt(){
        return this.predictedAt;
    }

    public athlete_profile getAthleteProfile(){
        return this.athlete_profile;
    }

    // Setter
      public void setPastInjuries(String pastInjuries){
        this.pastInjuries = pastInjuries; 
    }

    public void setRiskScore(BigDecimal riskScore){
        this.riskScore = riskScore;
    }

    public void setPredictedAt(LocalDate predictedAt){
        this.predictedAt = predictedAt;
    }

    public void setAthleteProfile(athlete_profile athlete_profile){
        this.athlete_profile = athlete_profile;
    }
}
