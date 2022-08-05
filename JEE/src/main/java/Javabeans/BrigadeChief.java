package Javabeans;

import java.util.ArrayList;







public class BrigadeChief extends Staff {
	ArrayList<Fine> fines;
	private ArrayList<Policeman> policemans;
	
	public ArrayList<Fine> getFines() {
		return fines;
	}
	public ArrayList<Policeman> getPolicemans() {
		return policemans;
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id,ArrayList<Fine> fines, ArrayList<Policeman> policemans) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}

	public BrigadeChief() {
		// TODO Auto-generated constructor stub
	}

}
