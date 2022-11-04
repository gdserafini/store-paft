package com.store.buy.options;

import com.store.database.db.ProductsDB;
import com.store.graphic.Graphic;
import com.store.product.Product;

import java.util.Scanner;

public class SearchProduct {
	
	private static final Scanner scan = new Scanner(System.in);
	
	public void search() {
		
		Graphic.printMsgProductName();
		var productName = scan.nextLine();
		
		if(searchProduct(productName) == null) { Graphic.printMsgNotFound(); return;}
		Graphic.printObject(searchProduct(productName));
	}
	
	private Product searchProduct(String productName) {
		var pdb = new ProductsDB();
		return pdb.getProduct(productName);
	}

}
