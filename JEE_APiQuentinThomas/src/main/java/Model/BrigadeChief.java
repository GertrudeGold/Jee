package Model;

import java.util.ArrayList;


import DAO.BrigadeChiefDAO;

public class BrigadeChief extends Staff {
private ArrayList<Policeman> policemans;
private ArrayList<Fine>fines;
	public BrigadeChief(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id,ArrayList<Policeman> policemans,ArrayList<Fine>fines) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}

	public BrigadeChief() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Policeman> getPolicemans() {
		return policemans;
	}
	public ArrayList<Fine> getFines() {
		return fines;
	}
	public static BrigadeChief login(String matricule,String pwd) {
		
		
		BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
		BrigadeChief brigadeChief =  brigadeChiefDAO.login(matricule, pwd);
	
	
	return brigadeChief;
	
}
public  BrigadeChief find(int id) {
		
		
		BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
		BrigadeChief brigadeChief =  brigadeChiefDAO.find(id);
	
	
	return brigadeChief;
	
}
public  static ArrayList<BrigadeChief> findAll() {
	
	
	BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
	ArrayList<BrigadeChief> brigadeChiefs =  brigadeChiefDAO.findAll();


return brigadeChiefs;

}
public  BrigadeChief findBrigadeChiefToAPoliceman(int id) {
	
	
	BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
	BrigadeChief brigadeChief =  brigadeChiefDAO.findBrigadeChiefToAPoliceman(id);


return brigadeChief;

}

}
