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
	public Policeman(String firstname, String lastname, String matricule,String password,BrigadeChief brigadeChief ) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
		this.brigadeChief=brigadeChief;
	}
	public Policeman(String firstname, String lastname, String matricule,int id ,BrigadeChief brigadeChief) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
		this.brigadeChief=brigadeChief;
	}
	public Policeman() {
		// TODO Auto-generated constructor stub
	}
	
public Policeman(String lastname, String firstname, String matricule, String password,int id)
{	super(firstname,lastname,matricule,password,id);
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
public Policeman findPolicemanToAFine(int id) {
	
	
	PolicemanDAO policemanDAO=new PolicemanDAO();
	Policeman policeman =  policemanDAO.findPolicemanToAFine(id);


return policeman;

}

public static ArrayList<Policeman> findPolicemanToAChief(int id){
	PolicemanDAO policemanDAO=new PolicemanDAO();
	ArrayList<Policeman> policemans =  policemanDAO.findPolicemanToAChief(id);
	return policemans;
}
public static ArrayList<Policeman> findAll(){
	PolicemanDAO policemanDAO=new PolicemanDAO();
	ArrayList<Policeman> policemans =  policemanDAO.findAll();
	return policemans;
}
public void setBrigadeChief(BrigadeChief brigadeChief) {
	this.brigadeChief = brigadeChief;
}

}
