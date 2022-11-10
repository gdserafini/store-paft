package com.store.database;

import java.sql.*;

public class ApiDB {
	
	public static boolean ping() {
		if(connect() == null) return false; 
		return true;
	}
	
	public static Connection connect() {

		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/store?user=root&password=password"
					);
		}
		catch(SQLException e) { e.printStackTrace(); } 
		
		return null;
	}
	
	public static void close(Connection conn, Statement stmt) {
		
		if(conn == null || stmt == null) {
			throw new IllegalArgumentException("Objetos indefinidos.");
		}
		
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
