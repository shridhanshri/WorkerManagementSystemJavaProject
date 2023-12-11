package work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.bo.SignUpBo;
import work.dao.Dao;

/**
 * Servlet implementation class WorkerManagement
 */
@WebServlet("/WorkerManagement")
public class WorkerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public WorkerManagement() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
	
	String Name=request.getParameter("Name");
	String Email=request.getParameter("Email");
	String DOJ=request.getParameter("DOJ");
	String Salary=request.getParameter("Salary");
	String Phoneno=request.getParameter("Phoneno");
	String Address=request.getParameter("Address");
	String Password=request.getParameter("Password");
	
	SignUpBo sb = new SignUpBo();
	
	sb.setName(Name);
	sb.setEmail(Email);
	sb.setDOJ(DOJ);
	sb.setSalary(Salary);
	sb.setPhoneno(Phoneno);
	sb.setAddress(Address);
	sb.setPassword(Password);
	
	int status =Dao.signedup( sb);
	
	if(status >0)
	{
		pw.print("Data Has been Successfully Inserted");
	}
	else
	{
		pw.print("Someting Went Wrong!!!");
	}
	
	
	
	
	
//	try
//	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera","root","Tina@2020");
//		
//		String sql="insert into  registration(Name,Email,DOJ,Salary,Phoneno,Address,Password) values(?,?,?,?,?,?,?)";
//		PreparedStatement ps =con.prepareStatement(sql);
//		ps.setString(1, Name);
//		ps.setString(2, Email);
//		ps.setString(3, DOJ);
//		ps.setString(4, Salary);
//		ps.setString(5, Phoneno);
//		ps.setString(6, Address);
//		ps.setString(7, Password);
//		ps.executeUpdate();
//		pw.print("Registered Successfully!!!!!!");
//		
//	}
//	catch(Exception e)
//	{
//		System.out.println(e);
//	}
//		
	}

}
