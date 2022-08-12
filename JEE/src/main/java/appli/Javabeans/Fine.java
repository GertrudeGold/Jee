package appli.Javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import appli.DAO.FineDAO;
import appli.DAO.ViolationDAO;



public class Fine implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 498916391356690082L;
private int id;
private Vehicle typeVehicle;
private Plate plate;
private Date date;
private String gultyFirstName;
private String gultyLastName;
private String comment;
private Policeman policeman;
private int validation; 
private ArrayList<Violation> violations;
public Fine(int id, Vehicle typeVehicle, Plate plate, Date date, String gultyFirstName, String gultyLastName,
		String comment, Policeman policeman,int validation,ArrayList<Violation> violations) {
	super();
	this.id = id;
	this.typeVehicle = typeVehicle;
	this.plate = plate;
	this.date = date;
	this.gultyFirstName = gultyFirstName;
	this.gultyLastName = gultyLastName;
	this.comment = comment;
	this.policeman = policeman;
	this.validation=validation;
	this.violations=violations;
}
public Fine( Vehicle typeVehicle, Plate plate, Date date, String gultyFirstName, String gultyLastName,
		String comment, Policeman policeman,int validation,ArrayList<Violation> violations) {
	super();
	this.typeVehicle = typeVehicle;
	this.plate = plate;
	this.date = date;
	this.gultyFirstName = gultyFirstName;
	this.gultyLastName = gultyLastName;
	this.comment = comment;
	this.policeman = policeman;
	this.validation=validation;
	this.violations=violations;
}
public Fine() {}
public int getId() {
	return id;
}
public Fine(int validation) {
	this.validation=validation;
}
public int getValidation() {
	return validation;
}
public ArrayList<Violation> getViolations() {
	return violations;
}
public Vehicle getTypeVehicle() {
	return typeVehicle;
}
public Plate getPlate() {
	return plate;
}
public Date getDate() {
	return date;
}
public String getGultyFirstName() {
	return gultyFirstName;
}
public String getGultyLastName() {
	return gultyLastName;
}
public String getComment() {
	return comment;
}
public Policeman getPoliceman() {
	return policeman;
}
public boolean insert(Fine fine) {
	boolean success;
	FineDAO fineDAO=new FineDAO();
	return success =  fineDAO.insert(fine);
}
public boolean delete(Fine fine) {
	boolean success;
	FineDAO fineDAO=new FineDAO();
	return success =  fineDAO.delete(fine);
}
public boolean update(Fine fine) {
	boolean success;
	FineDAO fineDAO=new FineDAO();
	return success =  fineDAO.update(fine);
}
public static ArrayList<Fine> findAll() {

	FineDAO fineDAO=new FineDAO();
	 return fineDAO.findAll();
}

}
