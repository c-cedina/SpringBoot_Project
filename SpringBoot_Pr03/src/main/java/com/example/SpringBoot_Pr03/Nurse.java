package com.example.SpringBoot_Pr03;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nurses")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String name;
	private String user;
	private String password;
	
    public Nurse() {
    }

	public Nurse(int id, String name, String user, String password) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.password = password;
	}
	
	public int getNurseId() {
		return id;
	}

	public void setNurseId(int nurseId) {
		this.id = nurseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}