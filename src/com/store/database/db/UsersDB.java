package com.store.database.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.store.database.ApiDB;
import com.store.graphic.Graphic;
import com.store.user.User;
import com.store.user.users.Admin;
import com.store.user.users.Client;

import java.util.ArrayList;
import java.util.List;

public class UsersDB {
	
	private String cpf;
	private String name;
	private String password;
	private int purchases;
	private double totalValue;
	
	public List<User> getAllUsers(){
		
		var conn = ApiDB.connect();
		
		List<User> users = new ArrayList<>();
		
		try {
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("SELECT * FROM tbUsers");
			
			while(rs.next()) {
				this.cpf = rs.getString("CPF");
				this.name = rs.getString("NAME");
				this.password = rs.getString("PASSWORD");
				this.purchases = rs.getInt("PURCHASES");
				this.totalValue = rs.getDouble("TOTAL_VALUE");
				
				if(this.cpf.equals("admin")) users.add(new Admin());
				else {
				
					var client = new Client(this.cpf, name, password);
					client.setPurchases(purchases);
					client.setTotalValue(totalValue);
					
					users.add(client);
				}
			}
			
			ApiDB.close(conn, stmt);
			
			return users;
			
			
		} catch (SQLException e) {
			Graphic.printMsgErrorGet();
			return null;
		}		
	}
	
	public User getUser(String cpf) {
		
		if(cpf.length() == 0 || cpf == null) {
			throw new IllegalArgumentException("CPF indefinido.");
		}
		
		var conn = ApiDB.connect();
		
		try {
			var stmt = conn.createStatement();
			var command = String.format("SELECT * FROM tbUsers WHERE CPF = \"%s\"", cpf);
			var rs = stmt.executeQuery(command);
			
			while(rs.next()) {
				this.cpf = rs.getString("CPF");
				this.name = rs.getString("NAME");
				this.password = rs.getString("PASSWORD");
				this.purchases = rs.getInt("PURCHASES");
				this.totalValue = rs.getDouble("TOTAL_VALUE");
			}
			
			ApiDB.close(conn, stmt);
			
			if(this.cpf == null) return null;
			
			if(this.cpf.equals("admin")) return new Admin();
			
			var client = new Client(this.cpf, name, password);
			client.setPurchases(purchases);
			client.setTotalValue(totalValue);
			
			return client;
			
			
		} catch (SQLException e) {
			Graphic.printMsgErrorGet();
			return null;
		}
	}
	
	public boolean deleteUser(String cpf) {
		
		if(cpf.length() == 0 || cpf == null) {
			throw new IllegalArgumentException("CPF indefinido.");
		}
		
		Connection conn = ApiDB.connect();
		
		if(getUser(cpf) == null) {
			Graphic.printMsgNotFound();
			return false;
		}
		else {
			try {
				var stmt = conn.prepareStatement("DELETE FROM tbUsers WHERE CPF = ?");
				stmt.setString(1, cpf);
				
				stmt.executeUpdate();
				
				Graphic.printMsgDeleted();
				
				return true;
				
			} catch (SQLException e) {
				Graphic.printMsgDeleteError();
				return false;
			}
		}
		
	}
	
	public boolean changeUser(String cpf, String name, String password, int purchases, double totalValue) {
		
		if(cpf.length() == 0 || cpf == null || name.length() == 0 || name == null || 
				password.length() == 0 || password == null) {
			throw new IllegalArgumentException("Dados inválidos.");
		}
		
		if(getUser(cpf) == null) {
			Graphic.printMsgNotFound();
			return false;
		}
		else {
		
			Connection conn = ApiDB.connect();
			
			try {
				var stmt = conn.prepareStatement(
						"UPDATE tbUsers SET NAME = ? , PASSWORD = ? , PURCHASES = ? , TOTAL_VALUE = ? WHERE CPF = ?");
				stmt.setString(1, name);
				stmt.setString(2, password);
				stmt.setInt(3, purchases);
				stmt.setDouble(4, totalValue);
				stmt.setString(5, cpf);
				
				stmt.executeUpdate();
				
				ApiDB.close(conn, stmt);
				
				Graphic.printMsgUpdateData();
				
				return true;
			
			} catch (SQLException e) {
				Graphic.printMsgErrorUpdate();
				return false;
			}
		}
		
	}
//	
	public boolean createUser(String cpf, String name, String password) {
		
		if(cpf.length() == 0 || cpf == null || name.length() == 0 || name == null || 
				password.length() == 0 || password == null) {
			throw new IllegalArgumentException("Dados inválidos.");
		}
		
		if(getUser(cpf) == null) {
		
			Connection conn = ApiDB.connect();
			
			try {
				var stmt = conn.prepareStatement(
						"INSERT INTO tbUsers (CPF, NAME, PASSWORD, PURCHASES, TOTAL_VALUE) VALUES (?,?,?,?,?)");
				stmt.setString(1, cpf);
				stmt.setString(2, name);
				stmt.setString(3, password);
				stmt.setInt(4, 0);
				stmt.setDouble(5, 0);
				
				stmt.executeUpdate();
				
				ApiDB.close(conn, stmt);
				
				return true;
			
			} catch (SQLException e) {
				Graphic.printMsgCreateError();
				return false;
			}
		}
		else {
			Graphic.printMsgAlreadyExists();
			return false;
		}		
	}

}
