package Javabeans;



public class Policeman extends Staff {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7025959542431967724L;
	private BrigadeChief brigadeChief;
	public Policeman(String firstname, String lastname, String matricule,String password ) {
		super(firstname, lastname, matricule,password);
		// TODO Auto-generated constructor stub
	}
	public Policeman(String firstname, String lastname, String matricule ,BrigadeChief brigadeChief,String password) {
		super(firstname, lastname, matricule,password);
		this.brigadeChief=brigadeChief;
		// TODO Auto-generated constructor stub
	}
	public Policeman(String firstname, String lastname, String matricule,int id ,BrigadeChief brigadeChief) {
		super(firstname, lastname, matricule,id);
		this.brigadeChief=brigadeChief;
		// TODO Auto-generated constructor stub
	}
	public Policeman() {
		// TODO Auto-generated constructor stub
	}
	public BrigadeChief getBrigadeChief() {
		return brigadeChief;
	}

}
