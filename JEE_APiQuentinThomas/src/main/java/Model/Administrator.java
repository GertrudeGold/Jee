package Model;

import DAO.AdministratorDAO;

public class Administrator extends Staff {

	public Administrator(String firstname, String lastname, String matricule,int id) {
		super(firstname, lastname, matricule,id);
		// TODO Auto-generated constructor stub
	}

	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	public static Administrator login(String matricule,String pwd) {
		
		
			 AdministratorDAO AdministratorDAO=new AdministratorDAO();
			Administrator admin =  AdministratorDAO.login(matricule, pwd);
		
		
		return admin;
		
	}
}
