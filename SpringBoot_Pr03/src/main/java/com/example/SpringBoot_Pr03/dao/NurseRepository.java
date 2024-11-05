package com.example.SpringBoot_Pr03.dao;

import org.springframework.data.repository.CrudRepository;
import entity.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	
	Nurse findByNurseUser(String nurseUser);
	Nurse findByNurseName(String nurseName);

}