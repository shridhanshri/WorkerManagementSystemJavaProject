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
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int Id = Integer.parseInt(request.getParameter("Id"));
		
		int status = Dao.getdeleteEmployee(Id);
		
		
		if(status>0)
		{
			pw.print("<script> alert('Data has been deleted successfully...') </script>");
			
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


