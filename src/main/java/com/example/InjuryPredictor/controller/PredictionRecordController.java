package com.example.InjuryPredictor.controller;

import com.example.InjuryPredictor.repositories.predictionRecordRepository;

import com.example.InjuryPredictor.model.PredictionRecord;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

public class PredictionRecordController{

    private final predictionRecordRepository operation;

    public PredictionRecordController(predictionRecordRepository operation){
        this.operation = operation;
    }

    public PredictionRecord createPredictionRecord(PredictionRecord record){
        return operation.save(record);
    }

    public List<PredictionRecord> listPredicitionRecord(){
        return operation.findAll();
    }

    public Optional<PredictionRecord> getPredictionRecordById(Long id){
        return operation.findById(id);
    }

    public Optional<PredictionRecord> updatePredicitionRecord(PredictionRecord updateRecord, Long id){
        return operation.findById(id).map(record -> {

           record.setPastInjuries(updateRecord.getPastInjuries());
           record.setPredictedAt(updateRecord.getPredictedAt());
           record.setRiskScore(updateRecord.getRiskScore());
           record.setAthleteProfile(updateRecord.getAthleteProfile());

           PredictionRecord saveRecord = operation.save(record); 

           return saveRecord;
        });
    } 

    public void deletePredicitionRecord(Long id){

        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
