package com.store.inventory.options;

import java.util.Scanner;
import com.store.database.db.*;
import com.store.graphic.Graphic;

public class AddNewProduct {
	
	private static final Scanner scan = new Scanner(System.in);
	private static final ProductsDB pdb = new ProductsDB();
	private double price;
	private int amount;
	private String name;
	
	public void add() {
			
			Graphic.printMsgProductName();
			this.name = scan.nextLine();
			
			if(this.pdb.getProduct(this.name) == null) {
			
				try { getNewPrice(); getNewAmount(); }
				catch(Exception e) { Graphic.printMsgInvalidType(); return; }
				
				if(this.pdb.createProduct(this.name, this.price, this.amount)) {
					Graphic.printMsgCreated();
				}
				else { Graphic.printMsgCreateError(); }
			}
			else { Graphic.printMsgAlreadyExists(); return; }
			
		}
		
	private void getNewPrice() {
		Graphic.printMsgEnterNewPrice();
		this.price = Double.parseDouble(scan.nextLine());
	}
	
	private void getNewAmount() {
		Graphic.printMsgEnterNewAmount();
		this.amount = scan.nextInt();
	}

}
