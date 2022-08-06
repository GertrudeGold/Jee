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

    public ListAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ArrayList<Staff> accounts=Staff.getAll();
		//request.setAttribute("Accounts", accounts);
		request.getRequestDispatcher("/WEB-INF/JSP/ListAccount.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
