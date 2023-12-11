package work.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.dao.Dao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter pw =response.getWriter();
		
		String Email =request.getParameter("Email");
		String Password = request.getParameter("Password");
		if(Dao.loginvalid(Email, Password))
		{
			pw.print("<script> alert('Login Successfull!!!') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script> alert('Wrong Credintial! Try again...!!') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
