package com.store.cart.options;

import com.store.cart.Cart;
import com.store.database.db.ProductsDB;
import com.store.database.db.UsersDB;
import com.store.login.Login;
import com.store.user.users.Client;

public class Purchase {
	
	private Cart cart;
	private Login login;
	
	public Purchase(Cart cart, Login login) {
		
		if(cart == null) {
			throw new IllegalArgumentException("Carrinho indefinido.");
		}
		
		this.cart = cart;
		this.login = login;
		
	}
	
	public void finish() {
		
		var udb = new UsersDB();
		var pdb = new ProductsDB();
		
		if(this.login.getLoggedUser().getClass() == Client.class) {
			var user = (Client)this.login.getLoggedUser();
		
			this.cart.getAllProducts().forEach(p -> {
					
					user.setPurchases(user.getPurchases()+1);
					user.setTotalValue(user.getTotalValue()+p.getPrice());
					
					p.setAmount(p.getAmount()-1);
					pdb.changeProduct(p.getName(), p.getPrice(), p.getAmount());
				
			});
			
			udb.changeUser(user.getCpf(), user.getName(), user.getPassword(), 
					user.getPurchases(), user.getTotalValue());
			
			this.cart.removeAllProducts();
			
		}
		else return;
		
	}

}
