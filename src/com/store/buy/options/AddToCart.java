package com.store.buy.options;

import java.util.Scanner;

import com.store.cart.Cart;
import com.store.database.db.ProductsDB;
import com.store.graphic.Graphic;

public class AddToCart {
	
	private int productAmount;
	private Cart cart;
	private static final Scanner scan = new Scanner(System.in);
	
	public AddToCart(Cart cart) {
		
		if(cart == null) {
			throw new IllegalArgumentException("Carrinho indefinido.");
		}
		
		this.cart = cart;
		
	}
	
	public void add() {
		
		Graphic.printMsgProductName();
		var productName = scan.nextLine();
		
		loopAdd(productName);
		
	}
	
	private void loopAdd(String productName) {
		
			while(true) {
			
			try {
				Graphic.printMsgEnterAmount();
				productAmount = scan.nextInt();
				
				if(hasInInventory(productName, productAmount)) {
					
					addToCart(productName, productAmount);
					break;
				}
				else {
					Graphic.printMsgNotPossibleAdd();
				}
			}
			catch(Exception e) {
				Graphic.printMsgInvalidType();
				return;
			}
			
		}	
	}
	
	private boolean hasInInventory(String productName, int productAmount) {
		
		var pdb = new ProductsDB();
		
		if(pdb.getProduct(productName).getAmount() >= productAmount) return true;
		return false;
		
	}
	
	private void addToCart(String productName, int productAmount) {
		
		var pdb = new ProductsDB();
		
		this.cart.addProduct(pdb.getProduct(productName), productAmount);
		
	}

}
