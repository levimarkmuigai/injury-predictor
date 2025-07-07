package com.example.InjuryPredictor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InjuryPredictor.model.PredictionRecord;

public interface predictionRecordRepository extends JpaRepository<PredictionRecord, Long>{}
