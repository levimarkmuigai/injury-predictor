package com.example.InjuryPredictor.service;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.model.PredictionRecord;

import org.springframework.stereotype.Service;

@Service
public class AthleteAdviceService{
    
    private final AiService aiService;

    private final SuggestionService suggestionService;

    public AthleteAdviceService(AiService aiService, SuggestionService suggestionService){

        this.aiService = aiService;

        this.suggestionService = suggestionService;
    }

    public  void generateSuggestions(AthleteProfile profile, PredictionRecord record){
        
        String prompt = suggestionService.buildPrompt(profile, record);

        String recommendation = aiService.chat(prompt);

        profile.setRecommendations(recommendation);
    }
}
