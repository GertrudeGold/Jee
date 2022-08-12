package Model;

import java.io.Serializable;

import DAO.PlateDAO;
import DAO.VehicleDAO;

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
public Plate() {
	
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
public Plate find(int id) {
	
	
	PlateDAO plateDAO=new PlateDAO();
	Plate plate =  plateDAO.find(id);


return plate;

}
public static Plate findIfAPlateExist(String plateinfo) {
	
	
	PlateDAO plateDAO=new PlateDAO();
	Plate plate =  plateDAO.findIfAPlateExist(plateinfo);


return plate;

}
}
