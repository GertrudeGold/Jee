package appli.Javabeans;

import java.io.Serializable;
import java.util.ArrayList;

import appli.DAO.CollectorDAO;
import appli.DAO.VehicleDAO;


public class Vehicle implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 2363164095821157286L;
private String type;
private int id;
public Vehicle(String type, int id) {
	super();
	this.type = type;
	this.id = id;
}
public Vehicle(String type) {
	super();
	this.type = type;
	
}
public Vehicle() {
	super();
	
	
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean insert(Vehicle vehicle) {
	boolean success;
	VehicleDAO vehicleDAO=new VehicleDAO();
	return success =  vehicleDAO.insert(vehicle);
}
public boolean delete(Vehicle vehicle) {
	boolean success;
	VehicleDAO vehicleDAO=new VehicleDAO();
	return success =  vehicleDAO.delete(vehicle);
}
public boolean update(Vehicle vehicle) {
	boolean success;
	VehicleDAO vehicleDAO=new VehicleDAO();
	return success =  vehicleDAO.update(vehicle);
}
public static ArrayList<Vehicle> findAll(){
	VehicleDAO vehicleDAO=new VehicleDAO();
	
	 return  vehicleDAO.findAll();
}
}
