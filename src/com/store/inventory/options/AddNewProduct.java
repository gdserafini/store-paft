package com.store.inventory.options;

import java.util.Scanner;
import com.store.database.db.*;
import com.store.graphic.Graphic;

public class AddNewProduct {
	
	private static final Scanner scan = new Scanner(System.in);
	
	public void add() {
		
		try {
			
			Graphic.printMsgProductName();
			var name = scan.nextLine();
			
			var pdb = new ProductsDB();
			
			if(pdb.getProduct(name) == null) {
			
				Graphic.printMsgEnterNewPrice();
				var price = Double.parseDouble(scan.nextLine());
				
				Graphic.printMsgEnterNewAmount();
				var amount = scan.nextInt();
				
				if(pdb.createProduct(name, price, amount)) {
					Graphic.printMsgCreated();
				}
				else {
					Graphic.printMsgCreateError();
				}
			}
			else {
				Graphic.printMsgAlreadyExists();
				return;
			}
			
		}
		catch(Exception e) {
			Graphic.printMsgInvalidType();
			return;
		}
		
	}

}
