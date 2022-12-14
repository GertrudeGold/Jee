package Model;

import java.util.ArrayList;

import DAO.AdministratorDAO;
import DAO.CollectorDAO;



public class Administrator extends Staff {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7328410463229366575L;
	ArrayList<Policeman> policemans = new ArrayList<Policeman>();
	ArrayList<Collector> collectors = new ArrayList<Collector>();
	ArrayList<BrigadeChief> brigadeChiefs = new ArrayList<BrigadeChief>();
	ArrayList<Administrator> administrators = new ArrayList<Administrator>();
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	ArrayList<Violation> violations = new ArrayList<Violation>();
	
	public Administrator(String firstname, String lastname, String matricule,int id,
			ArrayList<Policeman> policemans,ArrayList<Collector> collectors,ArrayList<BrigadeChief> brigadeChiefs,
			ArrayList<Administrator> administrators,ArrayList<Vehicle> vehicles,ArrayList<Violation> violations) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
		this.policemans=policemans;
		this.collectors=collectors;
		this.brigadeChiefs=brigadeChiefs;
		this.administrators=administrators;
		this.vehicles=vehicles;
		this.violations=violations;
	}
	public Administrator(String lastname, String firstname, String matricule, String password,int id)
	{	super(firstname,lastname,matricule,password,id);
			// TODO Auto-generated constructor stub
		}
	public Administrator(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public Administrator(String firstname, String lastname, String matricule, int id ) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Policeman> getPolicemans() {
		return policemans;
	}
	public ArrayList<Collector> getCollectors() {
		return collectors;
	}
	public ArrayList<BrigadeChief> getBrigadeChiefs() {
		return brigadeChiefs;
	}
	public ArrayList<Administrator> getAdministrators() {
		return administrators;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public ArrayList<Violation> getViolations() {
		return violations;
	}
	public static ArrayList<Administrator> findAll(){
		AdministratorDAO administratorDAO=new AdministratorDAO();
		ArrayList<Administrator> administrator =  administratorDAO.findAll();
		return administrator;
	}
	
	
}
