package Javabeans;

import java.io.Serializable;

import DAO.AdministratorDAO;
import DAO.BrigadeChiefDAO;
import DAO.CollectorDAO;
import DAO.PolicemanDAO;



public abstract class Staff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4499864673844308530L;
	private String firstname;
	private String lastname;
	private String matricule;
	private int id;
	private String password;
	public Staff(String firstname, String lastname, String matricule,String password) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.password=password;
	}
public Staff(String firstname, String lastname, String matricule,int id) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.id=id;
		
	}
	public Staff() {}
	
	public String getPassword() {
		return password;
	}

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
			 AdministratorDAO administratorDAO=new AdministratorDAO();
			 Administrator administrator =administratorDAO.login(matricule, pwd);
			 return administrator;
		}
		if(res.equals("pm")) {
			 PolicemanDAO PolicemanDAO=new PolicemanDAO();
			 Policeman policemanDAO =PolicemanDAO.login(matricule, pwd);
			 return policemanDAO;
		}
		if(res.equals("bc")) {
			 BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
			 BrigadeChief brigadeChief =brigadeChiefDAO.login(matricule, pwd);
			 return brigadeChief;
		}
		if(res.equals("co")) {
			 CollectorDAO collectorDAO=new CollectorDAO();
			 Collector collector =collectorDAO.login(matricule, pwd);
			 return collector;
		}
		
		return null;
		
	}
	public  boolean insert(Staff staff) {
		
		boolean success=false;
		 String res = "";
	     res = staff.getMatricule().substring(0,2);
	     if(res.equals("ad")) {
			 AdministratorDAO administratorDAO=new AdministratorDAO();
			
			 return  administratorDAO.insert((Javabeans.Administrator) staff);
		}
		if(res.equals("pm")) {
			 PolicemanDAO PolicemanDAO=new PolicemanDAO();
			 
			 return PolicemanDAO.insert((Policeman) staff);
		}
		if(res.equals("bc")) {
			 BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
			
			 return  brigadeChiefDAO.insert((BrigadeChief) staff);
		}
		if(res.equals("co")) {
			 CollectorDAO collectorDAO=new CollectorDAO();
			
			 return collectorDAO.insert((Collector)staff);
		}
		
		return success;
}
public  boolean delete(Staff staff) {
		
		boolean success=false;
		 String res = "";
	     res = staff.getMatricule().substring(0,2);
	     if(res.equals("ad")) {
			 AdministratorDAO administratorDAO=new AdministratorDAO();
			
			 return  administratorDAO.delete((Javabeans.Administrator) staff);
		}
		if(res.equals("pm")) {
			 PolicemanDAO PolicemanDAO=new PolicemanDAO();
			 
			 return PolicemanDAO.delete((Policeman) staff);
		}
		if(res.equals("bc")) {
			 BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
			
			 return  brigadeChiefDAO.delete((BrigadeChief) staff);
		}
		if(res.equals("co")) {
			 CollectorDAO collectorDAO=new CollectorDAO();
			
			 return collectorDAO.delete((Collector)staff);
		}
		
		return success;	
}
public  boolean update(Staff staff) {
	
	boolean success=false;
	 String res = "";
     res = staff.getMatricule().substring(0,2);
     if(res.equals("ad")) {
		 AdministratorDAO administratorDAO=new AdministratorDAO();
		
		 return  administratorDAO.update((Javabeans.Administrator) staff);
	}
	if(res.equals("pm")) {
		 PolicemanDAO PolicemanDAO=new PolicemanDAO();
		 
		 return PolicemanDAO.update((Policeman) staff);
	}
	if(res.equals("bc")) {
		 BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
		
		 return  brigadeChiefDAO.update((BrigadeChief) staff);
	}
	if(res.equals("co")) {
		 CollectorDAO collectorDAO=new CollectorDAO();
		
		 return collectorDAO.update((Collector)staff);
	}
	
	return success;
}
}
