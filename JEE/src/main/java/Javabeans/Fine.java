package Javabeans;

import java.io.Serializable;
import java.util.Date;

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
public Fine(int id, Vehicle typeVehicle, Plate plate, Date date, String gultyFirstName, String gultyLastName,
		String comment, Policeman policeman) {
	super();
	this.id = id;
	this.typeVehicle = typeVehicle;
	this.plate = plate;
	this.date = date;
	this.gultyFirstName = gultyFirstName;
	this.gultyLastName = gultyLastName;
	this.comment = comment;
	this.policeman = policeman;
}
public Fine() {}
public int getId() {
	return id;
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


}
