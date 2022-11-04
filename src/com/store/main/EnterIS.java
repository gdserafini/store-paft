package com.store.main;

import com.store.graphic.Graphic;
import com.store.inventory.MenuInventory;
import com.store.main.is.Relatory;
import com.store.user.Authenticable;
import com.store.user.User;
import com.store.user.users.Admin;

public class EnterIS {
	
	private static final int RELAT = 2;
	private static final int MNG_INV= 5;
	
	public boolean canEnter(Authenticable user) {
		return user.isAuthenticable();
	}
	
	public boolean canEnter(Admin user) {
		return user.isAdmin();
	}
	
	public boolean isAdmin(Authenticable user) {
		if(canEnter(user)) return user.isAdmin();
		else return false;
	}
	
	public void run(int option) {
		
		if(option == RELAT) {
			var relatory = new Relatory();
        	relatory.printUsers();
		}
		else if(option == MNG_INV) {
			
			var inventoryMenu = new MenuInventory();
			inventoryMenu.run();
			
		}
		else {
			Graphic.printMsgInvalidValue();
		}
		
	}
	
}
