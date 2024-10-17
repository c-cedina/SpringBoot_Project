package com.example.SpringBoot_Pr03;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nurse")
public class NurseController {
	
	private final NurseRepository nurseRepository;
	
    public NurseController(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }
	
    @GetMapping("/index")
    public ResponseEntity<List<Nurse>> getAll(){
    	return ResponseEntity.ok(nurses);
    }
    
    @PostMapping("/login")
	public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse loginNurse) {

		for (Nurse nurse : nurses) {
            if (nurse.getUser().equals(loginNurse.getUser()) && nurse.getPassword().equals(loginNurse.getPassword())) {
            	return ResponseEntity.ok(true);
            }
        }
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
    
    @GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name){
		for(Nurse nurse : nurses) {
			if(nurse.getName().equalsIgnoreCase(name)) {
				return ResponseEntity.ok(nurse);
			}
		}
		return ResponseEntity.notFound().build();
    }
}