package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nurseId;
	
    private String nurseName;
	private String nurseUser;
	private String nursePassword;
	
	public Nurse() {}
	
	public Nurse(int nurseId, String nurseName, String nurseUser, String nursePassword) {
		this.nurseName = nurseName;
		this.nurseUser = nurseUser;
		this.nursePassword = nursePassword;
	}

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
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