package Javabeans;

import java.util.ArrayList;


public class Collector extends Staff {

	ArrayList<Fine> fines;
	public Collector(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Collector(String firstname, String lastname, String matricule,int id,ArrayList<Fine> fines) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}

	public Collector() {
		// TODO Auto-generated constructor stub
	}

}
