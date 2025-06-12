package com.example.InjuryPredictor.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

import java.time.LocalDate;

public class PredictionRecord{
    
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
    private AthleteProfile athleteProfile;

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

    public PredictionRecord(){}

    public PredictionRecord(Long id, String pastInjuries, BigDecimal riskScore,
            LocalDate predictedAt, AthleteProfile athleteProfile){

        this.id = id;
        this.pastInjuries = pastInjuries;
        this.riskScore = riskScore;
        this.predictedAt = predictedAt;
        this.athleteProfile = athleteProfile;
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

    public AthleteProfile getAthleteProfile(){
        return this.athleteProfile;
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

    public void setAthleteProfile(AthleteProfile athleteProfile){
        this.athleteProfile = athleteProfile;
    }
}
