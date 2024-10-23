package com.example.SpringBoot_Pr03.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringBoot_Pr03.dao.NurseRepository;

import entity.Nurse;

@Controller
@RequestMapping("/nurse")
public class NurseController {
	
	private final NurseRepository nurseRepository;
	
    public NurseController(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }
	
    @GetMapping("/index")
    public @ResponseBody Iterable<Nurse> getAllUsers(){
    	return nurseRepository.findAll();
    }
    
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse loginNurse) {
    	// Get nurse by user's name
        Nurse nurse = nurseRepository.findByNurseUser(loginNurse.getNurseUser());

     // Check if nurse exists
        if (nurse != null) {
        	// Check password
            if (nurse.getNursePassword().equals(loginNurse.getNursePassword())) {
                return ResponseEntity.ok(true); // Login exitoso
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); // Login fallido
    }


    
    @GetMapping("/nurseName/{nurseName}")
    public @ResponseBody Optional<Nurse> findByNurseName(@PathVariable ("nurseName") String nurseName){
        return nurseRepository.findByNurseName(nurseName);
    }
}