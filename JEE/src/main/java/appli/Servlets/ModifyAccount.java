package appli.Servlets;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/ModifyAccount")
public class ModifyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyAccount() {
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
		
		String matricule = request.getParameter("matricule");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String password = request.getParameter("password");
		
		if (matricule.substring(0, 2).equals("ad")){
			ArrayList<Administrator> admins = connected.getAdministrators();
			for(Administrator admin: admins) {
				if(admin.getMatricule().equals(matricule)) {
					admin.setFirstname(firstname);
			    	admin.setLastname(lastname);
			    	admin.setPassword(password);
			    	admin.update(admin);	
				}
				
			}
		}
		if (matricule.substring(0, 2).equals("co")){
			ArrayList<Collector> collectors = connected.getCollectors();
			for(Collector collector: collectors) {
				if(collector.getMatricule().equals(matricule)) {
					collector.setFirstname(firstname);
					collector.setLastname(lastname);
					collector.setPassword(password);
				}
				
			}
		}
		if (matricule.substring(0, 2).equals("bc")){
			ArrayList<BrigadeChief> chiefs = connected.getBrigadeChiefs();
			for(BrigadeChief chief: chiefs) {
				if(chief.getMatricule().equals(matricule)) {
					chief.setFirstname(firstname);
					chief.setLastname(lastname);
					chief.setPassword(password);
					chief.update(chief);	
				}
				
			}
		}
		if (matricule.substring(0, 2).equals("pm")){
			ArrayList<Policeman> policemans = connected.getPolicemans();
			for(Policeman policeman: policemans) {
				if(policeman.getMatricule().equals(matricule)) {
					policeman.setFirstname(firstname);
					policeman.setLastname(lastname);
					policeman.setPassword(password);
					policeman.update(policeman);	
				}
				
			}
		}

		doGet(request, response);
	}

}
