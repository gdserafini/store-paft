package com.store.buy;

import java.util.Scanner;

import com.store.buy.options.AddToCart;
import com.store.buy.options.ListProducts;
import com.store.buy.options.SearchProduct;
import com.store.cart.Cart;
import com.store.cart.CartMenu;
import com.store.graphic.Graphic;
import com.store.login.Login;
import com.store.product.Product;

public class BuyMenu {
	
	private Login login;
	private Cart cart;
	private int choose;
	private int productAmount;
	private static final Scanner scan = new Scanner(System.in);
	private static final int SEARCH = 1;
	private static final int TO_LIST = 2;
	private static final int ADD = 3;
	private static final int CRT_MN = 4;
	private static final int EXIT = 5;
	
	public BuyMenu(Login login) {

        if(login == null){
            throw new IllegalArgumentException("Login indefinido.");
        }

		this.login = login;
		this.cart = new Cart();
	}
	
	public void run() {
		
		Graphic.printMsgBuyMenu();
		
		while(true) {
			
			try {
				Graphic.printBuyMenuOptions();
				choose = scan.nextInt();
			}
			catch(Exception e) {
				throw new IllegalArgumentException("Entrada de dados inválida.");
			}
				
				if(choose == SEARCH) {

					var searchProduct = new SearchProduct();
					searchProduct.search();
					
				}
				else if(choose == TO_LIST) {	

					var listProducts = new ListProducts();
					listProducts.list();
	
				}
				else if(choose == ADD) {
		
					var addToCart = new AddToCart(this.cart);
					addToCart.add();
					
				}
				else if(choose == CRT_MN) {

                    var cartMenu = new CartMenu(this.login, this.cart);
                    cartMenu.run();

				}
				else if(choose == EXIT){
					break;
				}
				else {
					Graphic.printMsgInvalidValue();
				}
		}	
	}
}
