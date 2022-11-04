package com.store.login;

import java.util.Scanner;

import com.store.database.db.UsersDB;
import com.store.graphic.Graphic;
import com.store.main.MainMenu;
import com.store.user.User;

public class EnterAccount {
	
	private static final Scanner scan = new Scanner(System.in);
	private Login login;
	
	public EnterAccount(Login login) {
		
		if(login == null) {
			throw new IllegalArgumentException("Login indefinido.");
		}
		
		this.login = login;
	}
	
	public void enter(String tempCpf) {
		
		while(true) {
			
			Graphic.printMsgEnterPassword();
			var tempPassword = scan.nextLine();
			
			if(this.login.validPasswordFormat(tempPassword)) {
				
				if(this.login.correctPassword(tempCpf, tempPassword)) {
					
					var udb = new UsersDB();
					var user = udb.getUser(tempCpf);
					
					this.login.setLoggedUser(user);
					var mainMenu = new MainMenu(this.login);
										
					mainMenu.run();
					
					break;
				}
				else {
					Graphic.printMsgIncorrectPassword();
				}
			}
			else {
				Graphic.printMsgInvalidFormat();
			}
		}
	}

}
