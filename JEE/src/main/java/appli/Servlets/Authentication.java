package appli.Servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
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

@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String apiKey;
       
    public Authentication() {
        super(); 
    }
    
    @Override
    public void init() throws ServletException{
    	super.init();
    	apiKey=getApiKey();
    }
    
    private String getApiKey() {
    	Context context;
		try 
		{
			context = new InitialContext();
			Context env = (Context) context.lookup("java:comp/env");
			return (String) env.getEnvironment().get("apiKey");
		} 
		catch (NamingException e) 
		{
			return "";
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession(false);
		if(session!=null){
			Staff staff = (Staff) session.getAttribute("ConnectedStaff");
			System.out.println("ici6");
			if(staff !=null && staff.getMatricule() != null) {
				if(staff instanceof Policeman) {

					response.sendRedirect("Policeman");

					request.getRequestDispatcher("/WEB-INF/JSP/HomePoliceman.jsp").forward(request,response);

					return;
				}
				if(staff instanceof BrigadeChief) {

					response.sendRedirect("BrigadeChief");
					request.getRequestDispatcher("/WEB-INF/JSP/HomeBrigadeChief.jsp").forward(request,response);
					return;
				}
				if(staff instanceof Collector) {
					response.sendRedirect("Collector");
					request.getRequestDispatcher("/WEB-INF/JSP/HomeCollector.jsp").forward(request,response);
					return;
				}
				if(staff instanceof Administrator) {
					System.out.println("ici7");

					//response.sendRedirect("AddAccount");
					request.getRequestDispatcher("/WEB-INF/JSP/HomeAdministrator.jsp").forward(request,response);
					return;
				}
			}			
				request.getRequestDispatcher("/WEB-INF/JSP/ConnectionPage.jsp").forward(request,response);
		}
}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		
		String matricule;
		String pwd;
		
		matricule=request.getParameter("matricule");
		pwd=request.getParameter("password");
		
		Object staff = Staff.login(matricule, pwd);
		if(staff != null) {
		if(staff instanceof Policeman) {
			Policeman policeman = (Policeman) staff;
			HttpSession session=request.getSession();
			if(!session.isNew()) {
				session.invalidate();
				session=request.getSession();
				}
				
				session.setAttribute("apiKey", apiKey);
				session.setAttribute("ConnectedStaff", policeman);
		}
		if(staff instanceof BrigadeChief) {
			
			BrigadeChief brigadeChief = (BrigadeChief) staff;
			HttpSession session=request.getSession();
			if(!session.isNew()) {
				session.invalidate();
				session=request.getSession();
				}
				
				session.setAttribute("apiKey", apiKey);
				session.setAttribute("ConnectedStaff", brigadeChief);
		}
		if(staff instanceof Collector) {
			
			Collector collector = (Collector) staff;
			HttpSession session=request.getSession();
			if(!session.isNew()) {
				session.invalidate();
				session=request.getSession();
				}
				
				session.setAttribute("apiKey", apiKey);
				session.setAttribute("ConnectedStaff", collector);
		}
		if(staff instanceof Administrator) {
			
			Administrator administrator = (Administrator) staff;
			HttpSession session=request.getSession();
			if(!session.isNew()) {
				session.invalidate();
				session=request.getSession();
				}
				
				session.setAttribute("apiKey", apiKey);
				session.setAttribute("ConnectedStaff", administrator);
		}
	}
		doGet(request, response);
	}

}
