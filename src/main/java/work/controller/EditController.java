package work.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.bo.SignUpBo;
import work.dao.Dao;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        int Id = Integer.parseInt(request.getParameter("Id"));

        SignUpBo sb = Dao.EmployeeDataById(Id);

        pw.print("<html><head><title>Edit User</title>");
        pw.print("<link rel=\"stylesheet\" href=\"css/edit.css\">");
        pw.print("</head><body>");

        pw.print("<form action='UpdateController' method='post'>");

        pw.print("<h1>Edit User</h1>");

        pw.print("<table>");

        pw.print("<tr><td> <input type='hidden' name='Id' value='" + sb.getId() + "'/></td></tr>");
        pw.print("<tr><td>Name: </td> <td> <input type='text' name='Name' value='" + sb.getName() + "'/></td></tr>");
        pw.print("<tr><td>Email: </td> <td> <input type='text' name='Email' value='" + sb.getEmail() + "'/></td></tr>");
        pw.print("<tr><td>DOJ: </td> <td> <input type='text' name='DOJ' value='" + sb.getDOJ() + "'/></td></tr>");
        pw.print("<tr><td>Salary: </td> <td> <input type='text' name='Salary' value='" + sb.getSalary() + "'/></td></tr>");
        pw.print("<tr><td>Phoneno: </td> <td> <input type='text' name='Phoneno' value='" + sb.getPhoneno() + "'/></td></tr>");
        pw.print("<tr><td>Address: </td> <td> <input type='text' name='Address' value='" + sb.getAddress() + "'/></td></tr>");
        pw.print("<tr><td>Password: </td> <td> <input type='text' name='Password' value='" + sb.getPassword() + "'/></td></tr>");

        pw.print("<tr> <td> <input type='submit' value='Update' class='btn'/></td></tr>");

        pw.print("</table>");

        pw.print("</form>");
        pw.print("</body></html>");
    }

}
