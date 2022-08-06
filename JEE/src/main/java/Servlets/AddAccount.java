package Servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabeans.Administrator;
import Javabeans.BrigadeChief;
import Javabeans.Collector;
import Javabeans.Policeman;
import Javabeans.Staff;

@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("ListAccount");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		Random random = new Random();
		int randNumber = random.nextInt(99999999 - 10000001) + 10000001;
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String password = request.getParameter("password");
		int idChief = 0;
		if(request.getParameter("ChiefId") != null){
			idChief = Integer.valueOf(request.getParameter("ChiefId"));	
		}
		int accountType = Integer.valueOf(request.getParameter("SelectedType"));	
		switch (accountType) {
		case 1:
			String ad_matricule = "ad" + randNumber;
			Staff administrator = new Administrator(firstname, lastname, ad_matricule, password);
			administrator.insert(administrator);
		    break;
		case 2:
			String co_matricule = "co" + randNumber;
			Staff collector = new Collector(firstname, lastname, co_matricule, password);
			collector.insert(collector);
			break;
		case 3:
			String bc_matricule = "bc" + randNumber;
			Staff chief = new BrigadeChief(firstname, lastname, bc_matricule, password);	
			chief.insert(chief);
			break;
		case 4:
			String pm_matricule = "pm" + randNumber;
			BrigadeChief bc = new BrigadeChief();
			bc = bc.findBrigadeChiefToAPoliceman(idChief);
			Staff policeman = new Policeman(firstname, lastname, pm_matricule, bc, password);	
			policeman.insert(policeman);
			break;
		}
		doGet(request, response);
	}

}
