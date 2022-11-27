package com.cognixia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/updateemployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
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
		
		int empid = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String title = request.getParameter("title");
		String department = request.getParameter("department");

//		// Set variables
//		int empid = 0;
//		String name = "";
//		int age = 0;
//		String street = "";
//		String city= "";
//		int zipcode = 0;
//		int salary = 0;
//		String title = "";
//		String department = "";
//		
//		// Get user inputs
//		try {
//			empid = Integer.parseInt(request.getParameter("empid"));
//			System.out.println(empid);
//			name = request.getParameter("name");
//			System.out.println(name);
//			age = Integer.parseInt(request.getParameter("age"));
//			System.out.println(age);
//			street = request.getParameter("street");
//			System.out.println(street);
//			city = request.getParameter("city");
//			System.out.println(city);
//			zipcode = Integer.parseInt(request.getParameter("zipcode"));
//			System.out.println(zipcode);
//			salary = Integer.parseInt(request.getParameter("salary"));
//			System.out.println(salary);
//			title = request.getParameter("title");
//			System.out.println(title);
//			department = request.getParameter("department");
//			System.out.println(department);
//			
//			System.out.println(empid);
//			System.out.println(name);
//			System.out.println(age);
//			System.out.println(street);
//			System.out.println(city);
//			System.out.println(zipcode);
//			System.out.println(salary);
//			System.out.println(title);
//			System.out.println(department);
//			
//			System.out.println("====================");
//		}
//		catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
		
		
		response.getWriter().print("<h1>Employee details has been updated successfully </h1>");
		
//		StringBuilder sb = new StringBuilder();
		String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
		String username = "root";
		String password = "mydb";		
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection connection = DriverManager.getConnection(url, username, password);
			 
//			 PreparedStatement pstmt_update = connection.prepareStatement("UPDATE employeemanagementsystem.employee SET empname = ?, empage = ?, empstreet = ?, empcity = ?, empzipcode = ?, empsalary = ?, emptitle = ?, empdept = ? WHERE idemployee = ?;");
			 
			 PreparedStatement pstmt_insert = connection.prepareStatement("UPDATE `employeemanagementsystem`.`employee` SET `empname` = ?, `empage` = ?, `empstreet` = ?, `empcity` = ?, `empzipcode` = ?, `empsalary` = ?, `emptitle` = ?, `empdept` = ? WHERE (`idemployee` = ?);");
			
			 // Get db record details
//			 PreparedStatement pstmt_select = connection.prepareStatement("SELECT * FROM employeemanagementsystem.employee WHERE idemployee = ?;");
//			 ResultSet result = pstmt_select.executeQuery();
//			 
//			 int db_empid =  result.getInt(1);
//			 String db_empname =  result.getString(2);
//			 int db_empage =  result.getInt(3);
//			 String db_empstreet =  result.getString(4);
//			 String db_empcity =  result.getString(5);
//			 int db_empzipcode =  result.getInt(6);
//			 int db_salary =  result.getInt(7);
//			 String db_title =  result.getString(8);
//			 String db_empdept =  result.getString(9);
//			 
//			 if (name != "") {
//				 pstmt_update.setString(1, name);
//			 }
//			 else
//				 pstmt_update.setString(1, db_empname);
//			 
//			 if (age > 0) {
//				 pstmt_update.setInt(2, age);
//			 }
//			 else
//				 pstmt_update.setInt(2, db_empage);
//			 
//			 if (street != "") {
//				 pstmt_update.setString(3, street);
//			 }
//			 else
//				 pstmt_update.setString(3, db_empstreet);
//			 
//			 if (city != "") {
//				 pstmt_update.setString(4, city);
//			 }
//			 else
//				 pstmt_update.setString(4, db_empcity);
//			 
//			 if (zipcode > 0) {
//				 pstmt_update.setInt(5, zipcode);
//			 }
//			 else
//				 pstmt_update.setInt(5, db_empzipcode);
//			 
//			 if (salary > 0) {
//				 pstmt_update.setInt(6, salary);
//			 }
//			 else
//				 pstmt_update.setInt(6, db_salary);
//			 
//			 if (title != "") {
//				 pstmt_update.setString(7, title);
//			 }
//			 else
//				 pstmt_update.setString(7, db_title);
//			 
//			 if (department != "") {
//				 pstmt_update.setString(8, department);
//			 }
//			 else
//				 pstmt_update.setString(8, db_empdept);
//			 
//			 pstmt_update.setInt(9, empid);
			 
			 
			 pstmt_insert.setString(1, name);
			 pstmt_insert.setInt(2, age);
			 pstmt_insert.setString(3, street);
			 pstmt_insert.setString(4, city);
			 pstmt_insert.setInt(5, zipcode);
			 pstmt_insert.setInt(6, salary);
			 pstmt_insert.setString(7, title);
			 pstmt_insert.setString(8, department);
			 pstmt_insert.setInt(9, empid);
			 
			 int row = pstmt_insert.executeUpdate();
			 System.out.println(row + " record updated");

		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
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
