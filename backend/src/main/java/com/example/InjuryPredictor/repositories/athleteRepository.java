package com.example.InjuryPredictor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InjuryPredictor.model.AthleteProfile;

public interface athleteRepository extends JpaRepository<AthleteProfile, Long>{}
