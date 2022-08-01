package Model;

import java.io.Serializable;

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
}
