package com.example.SpringBoot_Pr03;

import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	
	Nurse findByUser(String user);

}
