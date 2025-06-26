package com.example.InjuryPredictor.controller;

import com.example.InjuryPredictor.repositories.predictionRecordRepository;

import com.example.InjuryPredictor.model.PredictionRecord;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api/predictions")
public class PredictionRecordController{

    private final predictionRecordRepository operation;

    public PredictionRecordController(predictionRecordRepository operation){
        this.operation = operation;
    }

    @PostMapping
    public PredictionRecord createPredictionRecord(@RequestBody PredictionRecord record){
        return operation.save(record);
    }

    @GetMapping
    public List<PredictionRecord> listPredicitionRecord(){
        return operation.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PredictionRecord> getPredictionRecordById(@PathVariable Long id){
        return operation.findById(id);
    }

    @PutMapping("/{id}")
    public Optional<PredictionRecord> updatePredicitionRecord(@RequestBody PredictionRecord updateRecord, 
                                                            @PathVariable Long id){

        return operation.findById(id).map(record -> {

            record.setPastInjuries(updateRecord.getPastInjuries());
            record.setPredictedAt(updateRecord.getPredictedAt());
            record.setRiskScore(updateRecord.getRiskScore());
            record.setAthleteProfile(updateRecord.getAthleteProfile());

            PredictionRecord saveRecord = operation.save(record); 
                return saveRecord;
            });
    }

    @DeleteMapping("/{id}")
    public void deletePredicitionRecord(@PathVariable Long id){

        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
