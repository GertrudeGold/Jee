package Javabeans;

import java.io.Serializable;

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
	public Violation( String type, double price) {
		super();

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
	public boolean insert(Violation violation) {
		boolean success;
		ViolationDAO violationDAO=new ViolationDAO();
		return success =  violationDAO.insert(violation);
	}
	public boolean delete(Violation violation) {
		boolean success;
		ViolationDAO violationDAO=new ViolationDAO();
		return success =  violationDAO.delete(violation);
	}
	public boolean update(Violation violation) {
		boolean success;
		ViolationDAO violationDAO=new ViolationDAO();
		return success =  violationDAO.update(violation);
	}
}
