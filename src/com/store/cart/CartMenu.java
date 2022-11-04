package com.store.cart;

import java.util.Scanner;

import com.store.cart.options.Purchase;
import com.store.cart.options.RemoveCart;
import com.store.graphic.Graphic;
import com.store.login.Login;

public class CartMenu {
	
	private Login login;
	private Cart cart;
	private static final Scanner scan = new Scanner(System.in);
	private static final int PURCH = 1;
	private static final int REMOVE = 2;
	private static final int BTB = 3;
	private int choose;

	public CartMenu(Login login, Cart cart) {
		this.login = login;
		this.cart = cart;
	}
	
	public void run() {
		Graphic.printMsgCartMenu();
		
		while(true) {
			this.cart.printCart();
			
			try {
				Graphic.printCartOptions();
				choose = scan.nextInt();
			}
			catch(Exception e) {
				throw new IllegalArgumentException("Entrada de dados inválida.");
			}
				
				if(choose == PURCH) {		

					var purchase = new Purchase(this.cart, this.login);
					purchase.finish();
			
				}
				else if(choose == REMOVE) {	

					var removeCart = new RemoveCart(this.cart);
					removeCart.remove();
					
				}
				else if(choose == BTB) {
					break;
				}
				else {
					Graphic.printMsgInvalidValue();
				}
		}
	}	
}
