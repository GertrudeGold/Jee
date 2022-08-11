package appli.Javabeans;

import java.util.ArrayList;

import appli.DAO.CollectorDAO;
import appli.DAO.PolicemanDAO;


public class Collector extends Staff {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7415516270204843768L;
	ArrayList<Fine> fines;
	public Collector(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Collector(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public Collector(String firstname, String lastname, String matricule,int id,ArrayList<Fine> fines) {
		super(firstname, lastname, matricule,id);
		this.fines=fines;
		// TODO Auto-generated constructor stub
	}

	public Collector() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Collector> findAll(){
		CollectorDAO collectorDAO=new CollectorDAO();
		
		 return  collectorDAO.findAll();
	}
}
