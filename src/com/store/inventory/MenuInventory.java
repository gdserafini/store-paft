package com.store.inventory;

import java.util.Scanner;

import com.store.graphic.Graphic;
import com.store.inventory.options.AddNewProduct;
import com.store.inventory.options.ChangeProduct;
import com.store.inventory.options.RemoveProduct;

public class MenuInventory {

	private static final Scanner scan = new Scanner(System.in);
	private static final int CHANGE = 1;
	private static final int ADD = 2;
	private static final int REMOVE = 3;
	private static final int EXIT = 4;
	private int choose;
	
	public void run() {
		
		Graphic.printMsgInventoryMenu();
		
		while(true) {
			
			try {
				Graphic.printInventoryMenuOptions();
				choose = scan.nextInt();
			}
			catch(Exception e) {
				throw new IllegalArgumentException("Entrada de dados inválida.");
			}
				
				if(choose == CHANGE) {
					
					var changeProduct = new ChangeProduct();
					changeProduct.change();
					
				}
				else if(choose == ADD) {

					var addNewProduct = new AddNewProduct();
					addNewProduct.add();
                    
				}
				else if(choose == REMOVE) {

					var removeProduct = new RemoveProduct();
					removeProduct.remove();
					
				}
				else if(choose == EXIT) {
					break;
				}
				else {
                    Graphic.printMsgInvalidValue();
				}
		}	
	}	
}
