package com.store.cart.options;

import java.util.Scanner;

import com.store.cart.Cart;
import com.store.database.db.ProductsDB;
import com.store.graphic.Graphic;

public class RemoveCart {
	
	private Cart cart;
	private static final Scanner scan = new Scanner(System.in);
	
	public RemoveCart(Cart cart) {
		
		if(cart == null) {
			throw new IllegalArgumentException("Carrinho indefinido.");
		}
		
		this.cart = cart;
		
	}
	
	public void remove() {
		
		Graphic.printMsgProductName();
		var productName = scan.nextLine();
		
		removeFromCart(productName);
		
	}
	
	private void removeFromCart(String productName) {
		
		var pdb = new ProductsDB();
		this.cart.removeProduct(productName);
		
	}

}
