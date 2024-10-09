package com.example.SpringBoot_Pr03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NurseController {
	
	private static List<Nurse> nurses = new ArrayList<>();
	
    public NurseController() {
        nurses.add(new Nurse("Sergio", "sergio.nurse", "sergio123"));
        nurses.add(new Nurse("Chías", "chias.nurse", "chias123"));
        nurses.add(new Nurse("Gerard", "gerard.nurse", "gerard123"));
        nurses.add(new Nurse("Nil", "nil.nurse", "nil123"));
    }
	
    @GetMapping("/nurse/index")
    public ResponseEntity<List<Nurse>> getAll(){
    	return ResponseEntity.ok(nurses);
    }
    
    @PostMapping("/nurse/login")
	public boolean login(@RequestBody Nurse loginNurse) {

		for (Nurse nurse : nurses) {
            if (nurse.getUser().equals(loginNurse.getUser()) && nurse.getPassword().equals(loginNurse.getPassword())) {
            	return true;
            }
        }
		return false;
	}
    
    @GetMapping("/nurse/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name){
		for(Nurse nurse : nurses) {
			if(nurse.getName().equalsIgnoreCase(name)) {
				return ResponseEntity.ok(nurse);
			}
		}
		return ResponseEntity.notFound().build();
    }
}