package com.example.InjuryPredictor.service;

import org.springframework.stereotype.Component;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.model.PredictionRecord;

import java.time.LocalDate;

import java.time.Period;

import java.math.RoundingMode;


@Component
public class SuggestionService{

        private static final String TEMPLATE_SUGGESTIONS =
        "You are a sports physiotherapist assistant.%n" +
        "Provide exactly three short, concise suggestions for a %d-year-old athlete " +
        "(Height %d cm and Weight %d kg) with past injuries \"%s\", predicted injury \"%s\", risk score \"%s\":%n" +
        "1. Targeted exercise or stretch:%n" +
        "2. Training modification:%n" +
        "3. Recovery strategy:";

        public String buildPrompt(AthleteProfile profile,
                PredictionRecord record){
            
            if(profile == null){
               throw new IllegalArgumentException("Profile must not be null!"); 
            }
            if(record == null){
                throw new IllegalArgumentException("Record must not be null!");
            }

            int age = Period.between(profile.getDob(), LocalDate.now()).getYears();

            int height = profile.getHeight();

            int weight = profile.getWeight();

            String pastInjuries = record.getPastInjuries();

            String prediction = record.getPredictedInjury();

            String riskScore = record.getRiskScore()
                .setScale(2, RoundingMode.DOWN)
                .toPlainString();

            return String.format(
                        TEMPLATE_SUGGESTIONS,
                        age,
                        height,
                        weight,
                        pastInjuries,
                        prediction,
                        riskScore
                    );
        }
}
