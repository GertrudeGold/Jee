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
	public static boolean login(int matricule,String pwd) {
		boolean success=false;
		
			 AdministratorDAO AdministratorDAO=new AdministratorDAO();
			 //success=AdministratorDAO.login(matricule, pwd);
		
		
		return success;
		
	}
}
