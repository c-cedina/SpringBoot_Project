package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nurse_id")
    private int nurseId;
    private String name;
	private String user;
	private String password;
	
	public Nurse() {}
	
	public Nurse(int nurseId, String name, String user, String password) {
		this.nurseId = nurseId;
		this.name = name;
		this.user = user;
		this.password = password;
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