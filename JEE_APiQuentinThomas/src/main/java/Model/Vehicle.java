package Model;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.AdministratorDAO;
import DAO.PolicemanDAO;
import DAO.VehicleDAO;
import DAO.ViolationDAO;

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
public Vehicle find(int id) {
	
	
	VehicleDAO vehicleDAO=new VehicleDAO();
	Vehicle vehicle =  vehicleDAO.find(id);


return vehicle;
}
public static ArrayList<Vehicle> findAll(){
	VehicleDAO vehicleDAO=new VehicleDAO();
	ArrayList<Vehicle> vehicle = vehicleDAO.findAll();
	return vehicle;
}
public boolean insert(Vehicle vehicle) {
	boolean success;
	VehicleDAO vehicleDAO=new VehicleDAO();
	return success =  vehicleDAO.insert(vehicle);
}

}
