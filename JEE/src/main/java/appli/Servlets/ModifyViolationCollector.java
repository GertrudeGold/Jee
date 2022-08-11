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
import appli.Javabeans.Collector;
import appli.Javabeans.Violation;

@WebServlet("/ModifyViolationCollector")
public class ModifyViolationCollector extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyViolationCollector() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("ListViolationCollector");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Collector connected = (Collector) session.getAttribute("ConnectedStaff");
		
		String oldViolation = request.getParameter("oldType");
		double amount = Double.valueOf(request.getParameter("amount"));
		
		//ArrayList<Violation> violations = connected.getViolations();
		//for(Violation violation : violations) {
			//if(violation.getType().equals(oldViolation)) {
				//violation.setPrice(amount);
		    	//violation.update(violation);	
			//}
		//}
		doGet(request, response);
	}

}
