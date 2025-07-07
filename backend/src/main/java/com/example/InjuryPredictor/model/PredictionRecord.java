package com.example.InjuryPredictor.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

import java.time.LocalDate;

@Entity
@Table(name="Prediction_Record")
public class PredictionRecord{
    
    @Column(name="Id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="athlete_id", nullable=false)
    private AthleteProfile athleteProfile;

    @Column(name="Past Injuries", nullable=false)
    @NotNull(message="Past Injuries cannot be null!")
    private String pastInjuries;

    @Column(name="Prediction", nullable =false)
    @NotNull(message="Prediction cannot be null")
    private String predictedInjury;

    @Column(name="Risk_Level", nullable=false)
    @NotNull(message="Risk level cannot be null!")
    @Size(max=10)
    private String riskLevel;

    @Column(name="Risk_Score", nullable=false)
    @NotNull(message="Risk Score cannot be null!")
    private BigDecimal riskScore;

    @Column(name="Predicted_at", nullable=false)
    @PastOrPresent
    private LocalDate predictedAt;

    public PredictionRecord(){}

    public PredictionRecord(Long id, String pastInjuries,String predictedInjury, 
            BigDecimal riskScore,LocalDate predictedAt, AthleteProfile athleteProfile){

        this.id = id;
        this.pastInjuries = pastInjuries;
        this.predictedInjury = predictedInjury;
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

    public String getPredictedInjury(){
        return this.predictedInjury;
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

    public void setPredictedInjury(String predictedInjury){
        this.predictedInjury = predictedInjury;
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
