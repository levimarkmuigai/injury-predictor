package com.example.InjuryPredictor.service;

import org.springframework.stereotype.Component;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.model.PredictionRecord;

import java.time.LocalDate;

import java.time.Period;

import java.math.BigDecimal;

import java.util.Objects;

@Component
public class SuggestionService{
    
    private static final String TEMPLATE_SUGGESTIONS = 
        "You are a sports physiotherapist assistant.\n"+
        "Provide exactly three short, concise suggestions  for an athlete  %d-years-old "+
        "(Height %s cm and %s kg) with past injuries \"%s\", predicted injury \"%s\", risk score \"%s\": \n" +
        "1. Targeted exercise  or stretch:\n"+
        "2. Training modification:\n"+
        "3. Recovery strategy:";

    public String buildPrompt(AthleteProfile profile, PredictionRecord record){
        
        Objects.requireNonNull(profile, "profile");
        Objects.requireNonNull(record, "record");

        int age = Period.between(profile.getDob(), LocalDate.now()).getYears();

        BigDecimal height = profile.getHeight();

        BigDecimal weight = profile.getWeight();

        String pastInjuries = record.getPastInjuries();

        String prediction = record.getPredictedInjury();

        String risk = record.getRiskScore().toPlainString();

        return String.format(
                 TEMPLATE_SUGGESTIONS,
                 age,
                 height,
                 weight,
                 pastInjuries,
                 prediction,
                 risk
                );
    }
}
