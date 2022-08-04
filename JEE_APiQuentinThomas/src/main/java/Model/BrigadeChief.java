package Model;

import java.util.ArrayList;

public class BrigadeChief extends Staff {
private ArrayList<Policeman> policemans;
	public BrigadeChief(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id,ArrayList<Policeman> policemans) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}

	public BrigadeChief() {
		// TODO Auto-generated constructor stub
	}

}
