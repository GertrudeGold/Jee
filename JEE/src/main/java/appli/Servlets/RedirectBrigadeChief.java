package appli.Servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.BrigadeChief;
import appli.Javabeans.Fine;

@WebServlet("/RedirectBrigadeChief")
public class RedirectBrigadeChief extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectBrigadeChief() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession(false);
		BrigadeChief chief = (BrigadeChief) session.getAttribute("ConnectedStaff");
		//Will validate Fine
		if (request.getParameter("Validate") != null) {
			Fine fine = (Fine) request.getAttribute("fine");
			
        }
		//Will unvalidate Fine
		if (request.getParameter("Unvalidate") != null) {
			Fine fineToDelete = (Fine) request.getAttribute("fine");
			ArrayList<Fine> fines = chief.getFines();
			for(Fine fine:fines) {
				if(fine.equals(fineToDelete)) {
					fine.delete(fine);
					fines.remove(fineToDelete);
				}
			}	
        } 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
