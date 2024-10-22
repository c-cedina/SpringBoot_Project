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
import org.springframework.web.bind.annotation.RequestParam;
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
   /*    public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse loginNurse) {
        
   	// Get nurse by user's name
        Nurse nurse = nurseRepository.findByUser(loginNurse.getUser());

        if (nurse != null) {
            // Check password
            if (nurse.getPassword().equals(loginNurse.getPassword())) {
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

*/ 
    
    @GetMapping("/name/{name}")
	public @ResponseBody Optional<Nurse> findByName(@PathVariable ("name") String name){
		
		return nurseRepository.findByName(name);
    }
}