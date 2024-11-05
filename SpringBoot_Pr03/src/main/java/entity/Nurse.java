package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nurseId;
	
    private String name;
	private String nurseUser;
	private String nursePassword;
	
	public Nurse() {}
	
	public Nurse(int nurseId, String name, String nurseUser, String nursePassword) {
		this.name = name;
		this.nurseUser = nurseUser;
		this.nursePassword = nursePassword;
	}

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNurseUser() {
		return nurseUser;
	}

	public void setNurseUser(String nurseUser) {
		this.nurseUser = nurseUser;
	}

	public String getNursePassword() {
		return nursePassword;
	}

	public void setNursePassword(String nursePassword) {
		this.nursePassword = nursePassword;
	}
}