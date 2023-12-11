package work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.bo.SignUpBo;
import work.dao.Dao;

/**
 * Servlet implementation class AllRegisterUser
 */
@WebServlet("/AllRegisterUser")
public class AllRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllRegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<link rel=\"stylesheet\" href=\"css\\styles.css\">");
		pw.print("<a href=\"home.html\"> <input type=\"button\" id='btn' value=\"home\"></a> <br><br>");
		
		pw.print("<table border ='2px solid black' width='100%'>");
		pw.print("<tr> <th>Id</th> <th>Name</th> <th>Email</th> <th>DOJ</th>  <th>Salary</th> <th>Phoneno</th> <th>Address</th> <th>Password</th> <th>Update</th> <th>Delete</th></tr> ");
		
		List<SignUpBo> list = Dao.getAllRegisterUser();
		for(SignUpBo sb:list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td><td>"+sb.getEmail()+"</td><td>"+sb.getDOJ()+"</td><td>"+sb.getSalary()+"</td><td>"+sb.getPhoneno()+"</td><td>"+sb.getAddress()+"</td><td>"+sb.getPassword()+"</td> <td>"+"<a href='EditController?Id="+sb.getId()+"'>Edite </a> </td><td><a href='DeleteController?Id="+sb.getId()+"'>Delete </a></td></tr>");

		}
		
		
		pw.print("</table>");
	}

	

}
