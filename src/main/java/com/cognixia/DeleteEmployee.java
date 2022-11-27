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
 * Servlet implementation class deleteEmployee
 */
@WebServlet("/deleteemployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
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
		
		response.getWriter().print("<h1>Employee has been deleted successfully </h1>");
		
		String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
		String username = "root";
		String password = "mydb";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			 
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM employeemanagementsystem.employee WHERE idemployee = ?;");
			pstmt.setInt(1, empid);
			
			int row = pstmt.executeUpdate();
			 System.out.println(row + " record deleted");
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		response.getWriter().print("<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset=\"ISO-8859-1\">\r\n"
//				+ "<title>Insert title here</title>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+"<p>Employee ID </p>"
//				+ "<p>"+empid+"</p>"
//				+ "<p>has been deleted from system.</p>\r\n"
//				+ "</body>\r\n"
//				+ "</html>");
	}

}
