package Model;

import java.util.ArrayList;

import DAO.CollectorDAO;
import DAO.PolicemanDAO;



public class Collector extends Staff {
ArrayList<Fine> fines;
ArrayList<Violation> violations;
	public Collector(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Collector(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public Collector(String firstname, String lastname, String matricule,int id,ArrayList<Fine> fines,ArrayList<Violation> violations) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
		this.fines=fines;
		this.violations=violations;
	}
	public Collector(String lastname, String firstname, String matricule, String password,int id)
	{	super(firstname,lastname,matricule,password,id);
			// TODO Auto-generated constructor stub
		}
	public Collector() {
		// TODO Auto-generated constructor stub
	}
	public static Collector login(String matricule,String pwd) {
		
		
		CollectorDAO collectorDAO=new CollectorDAO();
		Collector collector =  collectorDAO.login(matricule, pwd);
	
	
	return collector;
	
}
	public static ArrayList<Collector> findAll(){
		CollectorDAO collectorDAO=new CollectorDAO();
		ArrayList<Collector> collector =  collectorDAO.findAll();
		return collector;
	}
	public ArrayList<Fine> getFines() {
		return fines;
	}
	public void setFines(ArrayList<Fine> fines) {
		this.fines = fines;
	}
	public ArrayList<Violation> getViolations() {
		return violations;
	}
	public void setViolations(ArrayList<Violation> violations) {
		this.violations = violations;
	}
	
}
