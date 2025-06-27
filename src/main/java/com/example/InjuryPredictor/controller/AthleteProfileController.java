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

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class AthleteProfileController{
    private final athleteRepository operation;

    public AthleteProfileController(athleteRepository operation){
        this.operation = operation;
    }

    // Create AtheleteProfile
    @PostMapping
    public ResponseEntity<AthleteProfile> createProfile(@RequestBody AthleteProfile athlete){

        AthleteProfile saved = operation.save(athlete);

        return ResponseEntity.ok(saved);
    }

    // List All the AthleteProfiles
    @GetMapping
    public ResponseEntity<List<AthleteProfile>> ListAllProfiles(){
        List<AthleteProfile> all = operation.findAll();

        return ResponseEntity.ok(all);
    }

    // Find AthleteProfile By id
    @GetMapping("/{id}")
    public ResponseEntity<AthleteProfile> getProfileById(@PathVariable Long id){
        return operation.findById(id).map(ResponseEntity::ok).
            orElse(ResponseEntity.notFound().build());
    }

    // Update the AthleteProfile by id
    @PutMapping("/{id}")
    public ResponseEntity<AthleteProfile> updateProfile(@PathVariable Long id, 
            @RequestBody AthleteProfile updatedProfile){

        return operation.findById(id)
            .map(existing -> {
                existing.setFirstName(updatedProfile.getFirstName());
                existing.setLastName(updatedProfile.getLastName());
                existing.setDob(updatedProfile.getDob());
                existing.setGender(updatedProfile.getGender());
                existing.setRegistrationDate(updatedProfile.getRegistrationDate());
                existing.setWeight(updatedProfile.getWeight());
                existing.setHeight(updatedProfile.getHeight());
                existing.setPredictions(updatedProfile.getPredictions());
                existing.setRecommendations(updatedProfile.getRecommendations());

            AthleteProfile saved = operation.save(existing);

            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build())
            
        ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
        if(!operation.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        operation.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
