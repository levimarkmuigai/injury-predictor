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

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class PredictionRecordController{

    private final predictionRecordRepository operation;

    public PredictionRecordController(predictionRecordRepository operation){
        this.operation = operation;
    }

    @PostMapping
    public ResponseEntity<PredictionRecord> createPredictionRecord(@RequestBody PredictionRecord record){
        PredictionRecord save = operation.save(record);

        return ResponseEntity.ok(save);
    }

    @GetMapping
    public ResponseEntity<List<PredictionRecord>> listRecords(){

        List<PredictionRecord> all = operation.findAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PredictionRecord> getRecordById(@PathVariable Long id){
        return operation.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.
                notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PredictionRecord> updateRecord(@RequestBody PredictionRecord updatedRecord, 
                                                            @PathVariable Long id){

        return operation.findById(id).map(record -> {

            record.setPastInjuries(updatedRecord.getPastInjuries());
            record.setPredictedInjury(updatedRecord.getPredictedInjury());
            record.setPredictedAt(updatedRecord.getPredictedAt());
            record.setRiskScore(updatedRecord.getRiskScore());
            record.setAthleteProfile(updatedRecord.getAthleteProfile());

            PredictionRecord save = operation.save(record); 
                return ResponseEntity.ok(save);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id){

        if(!operation.existsById(id)){
            ResponseEntity.notFound().build();
        }

        operation.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}
