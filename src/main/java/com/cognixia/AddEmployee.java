package com.cognixia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/addemployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empid = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String title = request.getParameter("title");
		String department = request.getParameter("department");
		
		response.getWriter().print("<h1>Employee Added Successfully </h1>");
		
//		StringBuilder sb = new StringBuilder();
		String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
		String username = "root";
		String password = "mydb";
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection connection = DriverManager.getConnection(url, username, password);
			 
			 PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `employeemanagementsystem`.`employee` (`idemployee`,`empname`, `empage`, `empstreet`, `empcity`, `empzipcode`, `empsalary`, `emptitle`, `empdept`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			 pstmt.setInt(1, empid);
			 pstmt.setString(2, name);
			 pstmt.setInt(3, age);
			 pstmt.setString(4, street);
			 pstmt.setString(5, city);
			 pstmt.setInt(6, zipcode);
			 pstmt.setInt(7, salary);
			 pstmt.setString(8, title);
			 pstmt.setString(9, department);
			 
			 int row = pstmt.executeUpdate();
			 System.out.println(row + " record inserted");

		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().print("<!DOCTYPE html>\r\n"
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
				+ "    <th>Employee ID</th>\r\n"
				+ "    <th>Name</th>\r\n"
				+ "    <th>Age</th>\r\n"
				+ "    <th>Street</th>\r\n"
				+ "    <th>City</th>\r\n"
				+ "    <th>Zipcode</th>\r\n"
				+ "    <th>Salary</th>\r\n"
				+ "    <th>Title</th>\r\n"
				+ "    <th>Department</th>\r\n"
				+ "  </tr>\r\n"
				+ "  <tr>\r\n"
				+ "    <td>"+empid+"</td>\r\n"
				+ "    <td>"+name+"</td>\r\n"
				+ "    <td>"+age+"</td>\r\n"
				+ "    <td>"+street+"</td>\r\n"
				+ "    <td>"+city+"</td>\r\n"
				+ "    <td>"+zipcode+"</td>\r\n"
				+ "    <td>"+salary+"</td>\r\n"
				+ "    <td>"+title+"</td>\r\n"
				+ "    <td>"+department+"</td>\r\n"
				+ "  </tr>\r\n"
				+ "</table>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
