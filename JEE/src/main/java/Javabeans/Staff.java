package Javabeans;

import java.io.Serializable;

public abstract class Staff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4499864673844308530L;
	private String firstname;
	private String lastname;
	private String matricule;
	private int id;
	public Staff(String firstname, String lastname, String matricule,int id) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.id=id;
	}
public Staff() {}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public int getId() {
	return id;
};

}
