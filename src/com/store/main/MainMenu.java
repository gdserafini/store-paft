package com.store.main;

import java.util.Scanner;
import com.store.buy.BuyMenu;
import com.store.graphic.Graphic;
import com.store.lib.Lib;
import com.store.login.Login;
import com.store.main.is.Relatory;
import com.store.user.Authenticable;
import com.store.user.users.Admin;

public class MainMenu {

	private Login login;
	private int choice;
	private static final Scanner scan = new Scanner(System.in);
	private static final int BUY = 1;
	private static final int RELAT = 2;
	private static final int CHA_USER = 3;
	private static final int ABOUT = 4;
	private static final int MNG_INV= 5;
	private static final int EXIT = 6;
	
	public MainMenu(Login login) {
		Lib.validsArgs(login);
		this.login = login;
	}
	
	public void run() {
		
		Graphic.printMsgMainMenu();
		
		while(true) {
			
			Graphic.printMainMenuOptions();
			this.choice = scan.nextInt();
			
			if(choice == BUY) { buy(); } 
			else if(choice == RELAT) { relatory(); }  
			else if(choice == CHA_USER) { break; }
			else if(choice == ABOUT) { Graphic.printMsgAbout(); }  
			else if(choice == MNG_INV) { manageInventory(); }  
			else if(choice == EXIT) { exit(); }  
			else Graphic.printMsgInvalidValue();
				
		}
	}
	
	private void buy() {
		var buyMenu = new BuyMenu(this.login);
        buyMenu.run();
	}
	
	private void relatory() {        
        try {
        	var is = new EnterIS();
            if(is.canEnter((Authenticable)this.login.getLoggedUser())) {
            	is.run(RELAT);
            }
        }
        catch(Exception e) {
        	Graphic.printMsgInvalidAcess();
        } 
	}
	
	private void manageInventory() {        
        try {
        	var is = new EnterIS();
            if(is.canEnter((Admin)this.login.getLoggedUser())) {
            	is.run(MNG_INV);
            }
        }
        catch(Exception e) {
        	Graphic.printMsgInvalidAcess();
        }
	}
	
	private void exit() {
		Graphic.printEnd();
		System.exit(0);
	}
}
