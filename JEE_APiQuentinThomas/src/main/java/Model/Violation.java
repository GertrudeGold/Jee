package Model;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.VehicleDAO;
import DAO.ViolationDAO;

public class Violation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1536481483965953429L;

	private int id ;
	private String type;
	private double price;
	public Violation(int id, String type, double price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}
	public Violation() {}
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public double getPrice() {
		return price;
	}
	public static ArrayList<Violation>GetViolationsOfAFine(int id) {
		
		
		ViolationDAO violationDAO=new ViolationDAO();
		ArrayList<Violation> violations =  violationDAO.GetViolationsToAFine(id);


	return violations;

	}
public static ArrayList<Violation>findAll() {
		
		
		ViolationDAO violationDAO=new ViolationDAO();
		ArrayList<Violation> violations =  violationDAO.findAll();


	return violations;

	}
}
