package Model;

import java.util.ArrayList;

import DAO.CollectorDAO;
import DAO.PolicemanDAO;

public class Policeman extends Staff {
	private BrigadeChief brigadeChief;
	public Policeman(String firstname, String lastname, String matricule,int id ) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Policeman(String firstname, String lastname, String matricule,String password ) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public Policeman(String firstname, String lastname, String matricule,int id ,BrigadeChief brigadeChief) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Policeman() {
		// TODO Auto-generated constructor stub
	}
	
public BrigadeChief getBrigadeChief() {
		return brigadeChief;
	}
public static Policeman login(String matricule,String pwd) {
		
		
		PolicemanDAO policemanDAO=new PolicemanDAO();
		Policeman policeman =  policemanDAO.login(matricule, pwd);
	
	
	return policeman;
	
}
public Policeman find(int id) {
	
	
	PolicemanDAO policemanDAO=new PolicemanDAO();
	Policeman policeman =  policemanDAO.find(id);


return policeman;

}
public static ArrayList<Policeman> findPolicemanToAChief(int id){
	PolicemanDAO policemanDAO=new PolicemanDAO();
	ArrayList<Policeman> policemans =  policemanDAO.findPolicemanToAChief(id);
	return policemans;
}
}
