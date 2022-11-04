package com.store.main;

import java.util.Scanner;
import com.store.buy.BuyMenu;
import com.store.graphic.Graphic;
import com.store.login.Login;
import com.store.main.is.Relatory;
import com.store.user.Authenticable;
import com.store.user.users.Admin;

public class MainMenu {

	private Login login;
	private int choose;
	private static final Scanner scan = new Scanner(System.in);
	private static final int BUY = 1;
	private static final int RELAT = 2;
	private static final int CHA_USER = 3;
	private static final int ABOUT = 4;
	private static final int MNG_INV= 5;
	private static final int EXIT = 6;
	
	public MainMenu(Login login) {
		
		if(login == null) {
			throw new IllegalArgumentException("Login indefinido.");
		}
		
		this.login = login;
	}
	
	public void run() {
		
		Graphic.printMsgMainMenu();
		
		while(true) {
			
			try {
				Graphic.printMainMenuOptions();
				this.choose = scan.nextInt();
			}
			catch(Exception e){
				throw new IllegalArgumentException("Entrada inválida de dados.");
			}
				
				if(this.choose == BUY) {

                    var buyMenu = new BuyMenu(this.login);
                    buyMenu.run();
					
				}
				else if(this.choose == RELAT) {

                    var is = new EnterIS();
                    
                    try {
	                    if(is.canEnter((Authenticable)this.login.getLoggedUser())) {
	                    	is.run(RELAT);
	                    }
                    }
                    catch(Exception e) {
                    	Graphic.printMsgInvalidAcess();
                    }                 				
				}
				else if(this.choose == CHA_USER) {
					break;
				}
				else if(this.choose == ABOUT){
                    Graphic.printMsgAbout();
				}
				else if(this.choose == MNG_INV) {

					var is = new EnterIS();
                    
                    try {
	                    if(is.canEnter((Admin)this.login.getLoggedUser())) {
	                    	is.run(MNG_INV);
	                    }
                    }
                    catch(Exception e) {
                    	Graphic.printMsgInvalidAcess();
                    }
				}
				else if(this.choose == EXIT) {
                    Graphic.printEnd();
					System.exit(0);
				}
				else {
					Graphic.printMsgInvalidValue();
				}
		}
	}
}
