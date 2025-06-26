package com.example.InjuryPredictor.controller;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.repositories.athleteRepository;

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
@RequestMapping("/api/profiles")
public class AthleteProfileController{
    private final athleteRepository operation;

    public AthleteProfileController(athleteRepository operation){
        this.operation = operation;
    }

    // Create AtheleteProfile
    @PutMapping
    public AthleteProfile createAtheleteProfile(AthleteProfile athlete){
        return operation.save(athlete);
    }

    // List All the AthleteProfiles
    @GetMapping
    public List<AthleteProfile> ListAllAtheleteProfiles(){
        return operation.findAll();
    }

    // Find AthleteProfile By id
    @GetMapping("/{id}")
    public Optional<AthleteProfile> getAtheleteProfileById(Long id){
        return operation.findById(id);
    }

    // Update the AthleteProfile by id
    @PutMapping("/{id}")
    public Optional<AthleteProfile> updateAthleteProfile(@PathVariable Long id, 
            @RequestBody AthleteProfile updateProfile){

        return operation.findById(id).map(profile -> {
            profile.setFirstName(updateProfile.getFirstName());
            profile.setLastName(updateProfile.getLastName());
            profile.setDob(updateProfile.getDob());
            profile.setGender(updateProfile.getGender());
            profile.setRegistrationDate(updateProfile.getRegistrationDate());
            profile.setWeight(updateProfile.getWeight());
            profile.setHeight(updateProfile.getHeight());
            profile.setPredictions(updateProfile.getPredictions());

            AthleteProfile saveProfile = operation.save(profile);

            return saveProfile;
        });
    }

    @DeleteMapping("/{id}")
    public void deleteAthleteProfile(Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
