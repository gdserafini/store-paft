package com.store.buy.options;

import com.store.database.db.ProductsDB;
import com.store.graphic.Graphic;

public class ListProducts {
	
	public void list() {
		
		var pdb = new ProductsDB();
		var products = pdb.getAllProducts();
		
		if(products.size() == 0) {Graphic.printMsgEmpty(); return;}
		products.stream().sorted().forEach(System.out::println);
		
	}

}
