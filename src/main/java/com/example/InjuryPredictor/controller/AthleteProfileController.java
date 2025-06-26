package com.example.InjuryPredictor.controller;

import com.example.InjuryPredictor.model.AthleteProfile;

import com.example.InjuryPredictor.repositories.athleteRepository;

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
    @PostMapping
    public AthleteProfile createProfile(@RequestBody AthleteProfile athlete){
        return operation.save(athlete);
    }

    // List All the AthleteProfiles
    @GetMapping
    public List<AthleteProfile> ListAllProfiles(){
        return operation.findAll();
    }

    // Find AthleteProfile By id
    @GetMapping("/{id}")
    public Optional<AthleteProfile> getProfileById(@PathVariable Long id){
        return operation.findById(id);
    }

    // Update the AthleteProfile by id
    @PutMapping("/{id}")
    public Optional<AthleteProfile> updateProfile(@PathVariable Long id, 
            @RequestBody AthleteProfile updatedProfile){

        return operation.findById(id).map(profile -> {
            profile.setFirstName(updatedProfile.getFirstName());
            profile.setLastName(updatedProfile.getLastName());
            profile.setDob(updatedProfile.getDob());
            profile.setGender(updatedProfile.getGender());
            profile.setRegistrationDate(updatedProfile.getRegistrationDate());
            profile.setWeight(updatedProfile.getWeight());
            profile.setHeight(updatedProfile.getHeight());
            profile.setPredictions(updatedProfile.getPredictions());

            AthleteProfile saveProfile = operation.save(profile);

            return saveProfile;
        });
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
