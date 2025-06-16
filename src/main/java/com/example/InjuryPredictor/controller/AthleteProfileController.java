package com.example.InjuryPredictor.controller;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.repositories.athleteRepository;

import java.util.List;

import java.util.Optional;

public class AthleteProfileController{
    private final athleteRepository operation;

    public AthleteProfileController(athleteRepository operation){
        this.operation = operation;
    }

    // Create AtheleteProfile
    public AthleteProfile createAtheleteProfile(AthleteProfile athlete){
        return operation.save(athlete);
    }

    // List All the AthleteProfiles
    public List<AthleteProfile> ListAllAtheleteProfiles(){
        return operation.findAll();
    }

    // Find AthleteProfile By id
    public Optional<AthleteProfile> getAtheleteProfileById(Long id){
        return operation.findById(id);
    }

    // Update the AthleteProfile by id
    public Optional<AthleteProfile> updateAthleteProfile(Long id, 
            AthleteProfile updateProfile){

        return operation.findById(id).map(profile -> {
            profile.setFirstName(updateProfile.getFirstName());
            profile.setLastName(updateProfile.getLastName());
            profile.setDob(updateProfile.getDob());
            profile.setGender(updateProfile.getGender());
            profile.setRegistrationDate(updateProfile.getRegistrationDate());
            profile.setWeight(updateProfile.getWeight());
            profile.setHeight(updateProfile.getHeight());
            profile.setPredictionRecord(updateProfile.getPredictionRecord());

            AthleteProfile saveProfile = operation.save(profile);

            return saveProfile;
        });
    }

    public void deleteAthleteProfile(Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
