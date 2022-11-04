package com.store.login;

import java.util.Scanner;
import com.store.graphic.Graphic;
import com.store.main.MainMenu;

public class MenuLogin {

	private Login login;
    private static final Scanner scan = new Scanner(System.in);
    
    public MenuLogin(Login login) {
    	
    	if(login == null) {
    		throw new IllegalArgumentException("Login indefinido");
    	}
    	
    	this.login = login;
    }
	
	public void run() {
		
		while(true) {
			Graphic.printMsgEnterCpf();
			var tempCpf = scan.nextLine();
			
			if(this.login.validCpfFormat(tempCpf)) {
				
				if(this.login.cpfExists(tempCpf)) {
					
					var enterAccount = new EnterAccount(this.login);
					enterAccount.enter(tempCpf);
					
				}
				else {
					Graphic.printMsgNotFound();
					
					Graphic.printMsgCreateAccount();
					var tempName = scan.nextLine();
					
					var createAccount = new CreateAccount(this.login);
					createAccount.create(tempCpf, tempName);
				}
			}
			else {
				Graphic.printMsgInvalidFormat();
			}
		}	
	}
}
