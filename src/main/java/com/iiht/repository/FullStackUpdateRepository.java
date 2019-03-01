package com.iiht.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iiht.dto.User;



public class FullStackUpdateRepository {
	
	
	public static void updateUser(User  user) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/iiht";
	    String username = "root";
	    String password = "pass@word1";
	    String sql = "update IIHT.TUSERS USER SET USER.FIRST_NAME=?,USER.LAST_NAME=? where USER.EMPLOYEE_ID=?" ;

	    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
	        PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			 stmt.setString(1, user.getFirstName()); 
			 stmt.setString(2,user.getLastName());
			 stmt.setInt(3, user.getEmployeeId());
			System.out.println("1------->"+user.getFirstName());
			System.out.println("2------->"+user.getLastName());
			System.out.println("3------->"+user.getEmployeeId());
	      
	     
	     int count = stmt.executeUpdate();
	     System.out.println("Count------------>"+count);
	      conn.setAutoCommit(true);
	      conn.close();
	      System.out.println("Record updated successfully");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
}
