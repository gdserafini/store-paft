package com.store.database.db;

import com.store.database.ApiDB;
import com.store.graphic.Graphic;
import com.store.product.Product;
import com.store.user.User;
import com.store.user.users.Admin;
import com.store.user.users.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDB {
	
	private String name;
	private double price;
	private int amount;
	
	public List<Product> getAllProducts(){
		
		var conn = ApiDB.connect();
		
		List<Product> products = new ArrayList<>();
		
		try {
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("SELECT * FROM tbProducts");
			
			while(rs.next()) {
				this.name = rs.getString("NAME");
				this.price = rs.getDouble("PRICE");
				this.amount = rs.getInt("AMOUNT");
					
				products.add(new Product(this.name, this.price, this.amount));
				
			}
			
			ApiDB.close(conn, stmt);
			
			return products;
			
			
		} catch (SQLException e) {
			Graphic.printMsgErrorGet();
			return null;
		}		
	}
	
	public Product getProduct(String name) {
		
		if(name.length() == 0 || name == null) {
			throw new IllegalArgumentException("Nome indefinido.");
		}
		
		var conn = ApiDB.connect();
		
		try {
			var stmt = conn.createStatement();
			var command = String.format("SELECT * FROM tbProducts WHERE NAME = \"%s\"", name);
			var rs = stmt.executeQuery(command);
			
			while(rs.next()) {
				this.name = rs.getString("NAME");
				this.price = rs.getDouble("PRICE");
				this.amount = rs.getInt("AMOUNT");
			}
			
			ApiDB.close(conn, stmt);
			
			if(this.name == null) return null;
			
			return new Product(this.name, this.price, this.amount);
			
			
		} catch (SQLException e) {
			Graphic.printMsgErrorGet();
			return null;
		}
	}
	
	public boolean deleteProduct(String name) {

		if(name.length() == 0 || name == null) {
			throw new IllegalArgumentException("Nome indefinido.");
		}
		
		Connection conn = ApiDB.connect();
		
		if(getProduct(name) == null) {
			Graphic.printMsgNotFound();
			return false;
		}
		else {
			try {
				var stmt = conn.prepareStatement("DELETE FROM tbProducts WHERE NAME = ?");
				stmt.setString(1, name);
				
				stmt.executeUpdate();
				
				ApiDB.close(conn, stmt);
				
				return true;
				
			} catch (SQLException e) {
				return false;
			}
		}
		
	}
	
	public boolean changeProduct(String name, double price, int amount) {
		
		if(name.length() == 0 || name == null || price < 0 || amount < 0) {
			throw new IllegalArgumentException("Dados inválidos.");
		}
		
		if(getProduct(name) == null) {
			Graphic.printMsgNotFound();
			return false;
		}
		else {
		
			Connection conn = ApiDB.connect();
			
			try {
				var stmt = conn.prepareStatement(
						"UPDATE tbProducts SET PRICE = ? , AMOUNT = ? WHERE NAME = ?");
				stmt.setDouble(1, price);
				stmt.setInt(2, amount);
				stmt.setString(3, name);
				
				stmt.executeUpdate();
				
				ApiDB.close(conn, stmt);
				
				return true;
			
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
	}
//	
	public boolean createProduct(String name, double price, int amount) {
		
		if(name.length() == 0 || name == null || price < 0 || amount < 0) {
			throw new IllegalArgumentException("Dados inválidos.");
		}
		
		if(getProduct(name) == null) {
		
			Connection conn = ApiDB.connect();
			
			try {
				var stmt = conn.prepareStatement(
						"INSERT INTO tbProducts (NAME, PRICE, AMOUNT) VALUES (?,?,?)");
				stmt.setString(1, name);
				stmt.setDouble(2, price);
				stmt.setInt(3, amount);
				
				stmt.executeUpdate();
				
				ApiDB.close(conn, stmt);
				
				return true;
			
			} catch (SQLException e) {
				return false;
			}
		}
		else {
			Graphic.printMsgAlreadyExists();
			return false;
		}		
	}
}
