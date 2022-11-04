package com.store.inventory.options;

import java.util.Scanner;
import com.store.database.db.*;
import com.store.graphic.Graphic;

public class RemoveProduct {
	
	private static final Scanner scan = new Scanner(System.in);
	
	public void remove() {
		
		Graphic.printMsgProductName();
		var name = scan.nextLine();
		
		var pdb = new ProductsDB();
		
		if(pdb.getProduct(name) == null) Graphic.printMsgNotFound();
		else {
			if(pdb.deleteProduct(name)) Graphic.printMsgDeleted();
		}
		
	}

}
