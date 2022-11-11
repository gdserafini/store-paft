package com.store.inventory.options;

import java.util.Scanner;

import com.store.database.db.ProductsDB;
import com.store.graphic.Graphic;
import com.store.lib.Lib;

public class ChangeProduct {
	
	private static final Scanner scan = new Scanner(System.in);
	private static final int PRICE = 1;
	private static final int AMOUNT = 1;
	private static final ProductsDB pdb = new ProductsDB();
	
	public void change() {
		
		Graphic.printMsgProductName();
		var productName = scan.nextLine();
		
		if(this.pdb.getProduct(productName) == null) Graphic.printMsgNotFound();
		else changeProductData(productName);
		
	}
	
	private void changeProductData(String productName) {
		Lib.validsArgs(productName);
		
			try {
				Graphic.printMsgOptionsChange();
				var choose = scan.nextInt();
				
				if(choose == PRICE) {
					Graphic.printMsgEnterNewPrice();
					var newPrice = Double.parseDouble(scan.nextLine());
					
					if(pdb.changeProduct(productName, newPrice, pdb.getProduct(productName).getAmount())) {
						Graphic.printMsgUpdateData();
					}
					else {
						Graphic.printMsgErrorUpdate();
					}
				}
				else if(choose == AMOUNT) {
					Graphic.printMsgEnterNewAmount();
					var newAmount = scan.nextInt();
					
					if(pdb.changeProduct(productName, pdb.getProduct(productName).getPrice(), newAmount)) {
						Graphic.printMsgUpdateData();
					}
					else {
						Graphic.printMsgErrorUpdate();
					}
				}
				else {
					Graphic.printMsgInvalidValue();
				}
			
			}
			catch(Exception e) {
				Graphic.printMsgInvalidType();
				return;
			}
	}

}
