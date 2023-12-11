package work.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.bo.SignUpBo;
import work.dao.Dao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int Id = Integer.parseInt(request.getParameter("Id"));
		
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String DOJ=request.getParameter("DOJ");
		String Salary=request.getParameter("Salary");
		String Phoneno=request.getParameter("Phoneno");
		String Address=request.getParameter("Address");
		String Password=request.getParameter("Password");
		
		
		SignUpBo sb = new SignUpBo();
		
		sb.setId(Id);
		sb.setName(Name);
		sb.setEmail(Email);
		sb.setDOJ(DOJ);
		sb.setSalary(Salary);
		sb.setPhoneno(Phoneno);
		sb.setAddress(Address);
		sb.setPassword(Password);
		
		
		int status = Dao.EmployeeData(sb);
		
		if(status>0)
		{
			pw.print("<script> alert('Data has been updated successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			
			rd.include(request, response);
			
			
		}
		
		
		
	}

}
