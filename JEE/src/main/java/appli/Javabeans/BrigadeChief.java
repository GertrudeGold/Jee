package appli.Javabeans;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import appli.DAO.AdministratorDAO;
import appli.DAO.BrigadeChiefDAO;
import appli.DAO.PolicemanDAO;


public class BrigadeChief extends Staff {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7415673420827099571L;
	ArrayList<Fine> fines;
	private ArrayList<Policeman> policemans;
	@JsonIgnoreProperties
	int chiefid;
	public ArrayList<Fine> getFines() {
		return fines;
	}
	public ArrayList<Policeman> getPolicemans() {
		return policemans;
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id,int chiefid) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
		this.chiefid=chiefid;
	}
	public BrigadeChief(String firstname, String lastname, String matricule,String password) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief(String firstname, String lastname, String matricule,int id,ArrayList<Fine> fines, ArrayList<Policeman> policemans,int chiefid) {
		super(firstname, lastname, matricule,id);
		this.fines=fines;
		this.chiefid=chiefid;
		// TODO Auto-generated constructor stub
	}

	public BrigadeChief() {
		// TODO Auto-generated constructor stub
	}
	public  BrigadeChief findBrigadeChiefToAPoliceman(int id) {
		
		
		BrigadeChiefDAO brigadeChiefDAO=new BrigadeChiefDAO();
		BrigadeChief brigadeChief =  brigadeChiefDAO.findBrigadeChiefToAPoliceman(id);


	return brigadeChief;

	}
	public int getChiefid() {
		return chiefid;
	}
	public void setChiefid(int chiefid) {
		this.chiefid = chiefid;
	}
	public void setFines(ArrayList<Fine> fines) {
		this.fines = fines;
	}
	public void setPolicemans(ArrayList<Policeman> policemans) {
		this.policemans = policemans;
	}
	public static ArrayList<Policeman> findAll(){
		PolicemanDAO policemanDAO=new PolicemanDAO();
		
		 return  policemanDAO.findAll();
	}
}
