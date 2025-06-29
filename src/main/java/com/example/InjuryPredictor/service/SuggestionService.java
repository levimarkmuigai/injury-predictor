package com.example.InjuryPredictor.service;

import org.springframework.stereotype.Component;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.model.PredictionRecord;

import java.time.LocalDate;

import java.math.BigDecimal;

@Component
public class SuggestionService{
    
    private static final String TEMPLATE_SUGGESTIONS = 
        "You are a sports physiotherapist assistant.\n"+
        "Provide exactly three short, concise suggestions  for an athlete born on %d "+
        "(Height %d cm and %d kg) with past injuries \"%s\", predicted injury \"%s\", risk score \"%s\": \n" +
        "1. Targeted exercise  or stretch:\n"+
        "2. Training modification:\n"+
        "3. Recovery strategy:";

    public String buildPrompt(AthleteProfile profile, PredictionRecord record){
        
        if(profile == null){
            
            throw new IllegalArgumentException("Athlete must not be null.");
        }

        LocalDate dob = profile.getDob();

        BigDecimal height = profile.getHeight();

        BigDecimal weight = profile.getWeight();

        String pastInjuries = record.getPastInjuries();

        String prediction = record.getPredictedInjury();

        BigDecimal riskScore = record.getRiskScore();

        return String.format(
                 TEMPLATE_SUGGESTIONS,
                 dob,
                 height,
                 weight,
                 pastInjuries != null ? pastInjuries : "unknown",
                 prediction != null ? prediction : "none",
                 riskScore != null ? riskScore : 0.0
                );
    }
}
