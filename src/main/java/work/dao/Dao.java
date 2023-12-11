package work.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import work.bo.SignUpBo;

public class Dao {

	public static Connection getConnection()
	{
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera","root","Tina@2020");
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static int signedup(SignUpBo sb1)
	{
		int status= 0;
		try {
			
			Connection con =Dao.getConnection();
			String sql="insert into  registration(Name,Email,DOJ,Salary,Phoneno,Address,Password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps =con.prepareStatement(sql);
			
			ps.setString(1,sb1.getName());
			ps.setString(2, sb1.getEmail());
			ps.setString(3, sb1.getDOJ());
			ps.setString(4, sb1.getSalary());
			ps.setString(5, sb1.getPhoneno());
			ps.setString(6, sb1.getAddress());
			ps.setString(7, sb1.getPassword());
			status=ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean loginvalid( String Email ,String Password )
	{
		
		boolean status =false;
		try {
			
			Connection con = Dao.getConnection();
			 String sql = "select * from registration where Email=? and Password=?"; 
			 PreparedStatement ps= con.prepareStatement(sql);
			 ps.setString(1, Email);
			 ps.setString(2, Password);
			 ResultSet rs =ps.executeQuery();
			  status = rs.next();
			
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static List getAllRegisterUser() {
	    ArrayList<SignUpBo> list = new ArrayList<SignUpBo>();
	    try {
	        Connection con = Dao.getConnection();
	        String sql = "select * from registration";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            SignUpBo sb = new SignUpBo();
	            sb.setId(rs.getInt(1));
	            sb.setName(rs.getString(2));
	            sb.setEmail(rs.getString(3));
	            sb.setDOJ(rs.getString(4));
	            sb.setSalary(rs.getString(5));
	            sb.setPhoneno(rs.getString(6));
	            sb.setAddress(rs.getString(7));
	            sb.setPassword(rs.getString(8));

	            list.add(sb);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list; // Return the list of registered users, not null
	}
	
	public static SignUpBo EmployeeDataById(int Id)
	{
		SignUpBo sb = new SignUpBo();
		try {
			 Connection con = Dao.getConnection();
		        String sql = "select * from registration where Id=?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, Id);
		        ResultSet rs = ps.executeQuery();
		        
		        while (rs.next()) {
		            
		            sb.setId(rs.getInt(1));
		            sb.setName(rs.getString(2));
		            sb.setEmail(rs.getString(3));
		            sb.setDOJ(rs.getString(4));
		            sb.setSalary(rs.getString(5));
		            sb.setPhoneno(rs.getString(6));
		            sb.setAddress(rs.getString(7));
		            sb.setPassword(rs.getString(8));

		            
		        }
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb;
		
	}
	
	public static int EmployeeData( SignUpBo sb)
	{
		int status=0;
		try {
			 Connection con = Dao.getConnection();
		        String sql = "update registration set Name=?,Email=?,DOJ=?,Salary=?,Phoneno=?,Address=?,Password=? where Id=?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        
		        	ps.setString(1, sb.getName());	
		        	ps.setString(2, sb.getEmail());
		        	ps.setString(3, sb.getDOJ());
		        	ps.setString(4, sb.getSalary());
		        	ps.setString(5, sb.getPhoneno());
		        	ps.setString(6, sb.getAddress());
		        	ps.setString(7, sb.getPassword());
		        	ps.setInt(8, sb.getId());
		        
		            status=ps.executeUpdate();
		            

		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	public static int getdeleteEmployee(int Id)
	{
		int status = 0;
		
		try 
		{
			Connection con = Dao.getConnection();
			
			String sql = "delete from registration where Id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, Id);
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
			
	}

	
}
