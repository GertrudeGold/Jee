package Javabeans;

import java.io.Serializable;

import DAO.AdministratorDAO;


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
	public static Staff login(String matricule,String pwd) {
		
		 String res = "";
	     res = matricule.substring(0,2);
		if(res.equals("ad")) {
			 AdministratorDAO AdministratorDAO=new AdministratorDAO();
			 Administrator administrator =AdministratorDAO.login(matricule, pwd);
			 return administrator;
		}
//		if(matricule>=30000 && matricule<40000) {
//			LeaderDAO leaderDAO=new LeaderDAO();
//			success=leaderDAO.login(matricule, pwd);
//		}
//		if(matricule>=40000 && matricule<50000) {
//			EmployeeDAO employeeDAO=new EmployeeDAO();
//			success=employeeDAO.login(matricule,pwd);
//		}
		
		return null;
		
	}
}
