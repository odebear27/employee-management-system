package com.cognixia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListEmployees
 */
@WebServlet("/listemployees")
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
		String username = "root";
		String password = "mydb";
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection connection = DriverManager.getConnection(url, username, password);
			 Statement statement = connection.createStatement();
			 
			 ResultSet result = statement.executeQuery("SELECT * FROM employeemanagementsystem.employee;");
			 
			 while (result.next()) {
				System.out.println("====================");
				int empid =  result.getInt(1);
				sb.append("<tr><td>"+empid+"</td>");
				String empname =  result.getString(2);
				sb.append("<td>"+empname+"</td>");
				int empage =  result.getInt(3);
				sb.append("<td>"+empage+"</td>");
				String empstreet =  result.getString(4);
				sb.append("<td>"+empstreet+"</td>");
				String empcity =  result.getString(5);
				sb.append("<td>"+empcity+"</td>");
				int empzipcode =  result.getInt(6);		
				sb.append("<td>"+empzipcode+"</td>");
				int salary =  result.getInt(7);		
				sb.append("<td>"+salary+"</td>");
				String title =  result.getString(8);
				sb.append("<td>"+title+"</td>");
				String empdept =  result.getString(9);
				sb.append("<td>"+empdept+"</td>");
				
				
				System.out.println(empid);
				System.out.println(empname);
				System.out.println(empage);
				System.out.println(empdept);
				System.out.println(empstreet);
				System.out.println(empcity);
				System.out.println(empzipcode);
				
				System.out.println("====================");
			 }
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
//		response.getWriter().print(
				
String start="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Table</title>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table>\r\n"
				+ "  <tr>\r\n"
				+ "    <th>ID</th>\r\n"
				+ "    <th>Name</th>\r\n"
				+ "    <th>Age</th>\r\n"	
				+ "    <th>Street</th>\r\n"
				+ "    <th>City</th>\r\n"
				+ "    <th>Zipcode</th>\r\n"
				+ "    <th>Department</th>\r\n"
				+ "    <th>Salary</th>\r\n"
				+ "    <th>Ttile</th>\r\n"			
				+ "  </tr>";
				

			String end = 	"</table>\r\n"
				+ "</body>\r\n"
				+ "</html>";

		response.getWriter().print(start+sb.toString()+end);
	}


}
