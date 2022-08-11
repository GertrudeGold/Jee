package appli.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.Administrator;
import appli.Javabeans.BrigadeChief;
import appli.Javabeans.Collector;
import appli.Javabeans.Policeman;
import appli.Javabeans.Staff;

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
		Administrator connected = (Administrator) session.getAttribute("ConnectedStaff");

		
		Random random = new Random();
		int randNumber = random.nextInt(99999999 - 10000001) + 10000001;
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String password = request.getParameter("password");
		int idChief = 0;
		if(!request.getParameter("ChiefId").equals("")){
			idChief = Integer.valueOf(request.getParameter("ChiefId"));	
		}
		int accountType = Integer.valueOf(request.getParameter("SelectedType"));	
		switch (accountType) {
		case 1:
			
			String ad_matricule = "ad" + randNumber;
			Staff administrator = new Administrator(firstname, lastname, ad_matricule, password);
			administrator.insert(administrator);
			
//			ArrayList<Administrator> admins = connected.getAdministrators();
			connected.setAdministrators(Administrator.findAll());
			
		    break;
		case 2:
			ArrayList<Collector> collectors = connected.getCollectors();
			String co_matricule = "co" + randNumber;
			Staff collector = new Collector(firstname, lastname, co_matricule, password);
			collector.insert(collector);
			collectors.add((Collector) collector);
			break;
		case 3:
			ArrayList<BrigadeChief> chiefs = connected.getBrigadeChiefs();
			String bc_matricule = "bc" + randNumber;
			Staff chief = new BrigadeChief(firstname, lastname, bc_matricule, password);	
			chief.insert(chief);
			chiefs.add((BrigadeChief) chief);
			break;
		case 4:
			ArrayList<Policeman> policemans = connected.getPolicemans();
			String pm_matricule = "pm" + randNumber;
			BrigadeChief bc = new BrigadeChief();
			bc = bc.findBrigadeChiefToAPoliceman(idChief);
			Staff policeman = new Policeman(firstname, lastname, pm_matricule, bc, password);	
			policeman.insert(policeman);
			policemans.add((Policeman) policeman);
			break;
		}
		doGet(request, response);
	}

}
