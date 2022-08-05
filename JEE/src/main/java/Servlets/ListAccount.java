package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Javabeans.Staff;

@WebServlet("/ListAccount")
public class ListAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String apiKey;
	private static ArrayList<Staff> accounts;
	
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

    public ListAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	super.init();
    	apiKey=getApiKey();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/JSP/ListAccount.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
