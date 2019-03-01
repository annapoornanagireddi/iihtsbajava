package com.iiht.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iiht.dto.User;

public class FullStackDeleteRepository {
	
	public static void deleteUser(int  employeeId) {
	String jdbcUrl = "jdbc:mysql://localhost:3306/iiht";
    String username = "root";
    String password = "pass@word1";
    String sql = "delete from IIHT.TUSERS where EMPLOYEE_ID=?" ;

    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      
      stmt.setInt(1, employeeId);
      stmt.executeUpdate();
      
      System.out.println("Record deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
	
	
}
