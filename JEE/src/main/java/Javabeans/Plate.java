package Javabeans;

import java.io.Serializable;

public class Plate implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -5607881116052982391L;
private int id;
private String plateinformation;
public Plate(int id, String plateinformation) {
	super();
	this.id = id;
	this.plateinformation = plateinformation;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPlateinformation() {
	return plateinformation;
}
public void setPlateinformation(String plateinformation) {
	this.plateinformation = plateinformation;
}

}
