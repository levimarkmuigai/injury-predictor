package com.example.InjuryPredictor.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.model.PredictionRecord;

import java.time.LocalDate;

import java.math.BigDecimal;

class SuggestionServiceTest{
    private SuggestionService service;

    @BeforeEach
    void setUp(){
        service = new SuggestionService();
    }

    @Test
    void buildPrompt_happyPath_returnsFormattedPrompt(){    
        
        AthleteProfile profile = new AthleteProfile();
        profile.setDob(LocalDate.of(2000, 1, 1));
        profile.setHeight(180);
        profile.setWeight(75);

        PredictionRecord record = new PredictionRecord();
        record.setPastInjuries("sprained ankle");
        record.setPredictedInjury("ACL tear");
        record.setRiskScore(new BigDecimal("0.875"));

        String prompt = service.buildPrompt(profile, record);

        assertTrue(prompt.contains("25-year-old athlete"));
        assertTrue(prompt.contains("Height 180 cm"));
        assertTrue(prompt.contains("Weight 75 kg"));
        assertTrue(prompt.contains("sprained ankle"));
        assertTrue(prompt.contains("ACL tear"));
        assertTrue(prompt.contains("0.87"));
        assertTrue(prompt.contains("1. Targeted exercise or stretch:"));
        assertTrue(prompt.contains("2. Training modification:"));
        assertTrue(prompt.contains("3. Recovery strategy:"));
    }

    @Test
    void buildPrompt_nullProfile_ThrowException(){

        PredictionRecord record = new PredictionRecord();
        
        record.setPastInjuries("none");
        
        record.setPredictedInjury("none");
        
        record.setRiskScore(new BigDecimal(0.0));

        assertThrows(IllegalArgumentException.class,
                () -> service.buildPrompt(null, record), 
                "Expected exception for null profile.");
    }

    @Test
    void buildPrompt_nullRecord_ThrowException(){
        
        AthleteProfile profile = new AthleteProfile(); 
        
        profile.setDob(LocalDate.now().minusYears(30));
        
        profile.setHeight(180);

        profile.setWeight(75);

        assertThrows(IllegalArgumentException.class,
                () -> service.buildPrompt(profile, null),
                "Expected exception for null record.");
    }
}
