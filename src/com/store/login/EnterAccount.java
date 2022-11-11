package com.store.login;

import java.util.Scanner;

import com.store.database.db.UsersDB;
import com.store.graphic.Graphic;
import com.store.lib.Lib;
import com.store.main.MainMenu;
import com.store.user.User;

public class EnterAccount {
	
	private static final Scanner scan = new Scanner(System.in);
	private Login login;
	private static final UsersDB udb = new UsersDB();
	
	public EnterAccount(Login login) {
		Lib.invalidArgs(login);
		this.login = login;
	}
	
	public void enter(String tempCpf) {
		Lib.invalidArgs(tempCpf);
		
		while(true) {
			
			Graphic.printMsgEnterPassword();
			var tempPassword = scan.nextLine();
			
			if(this.login.validPasswordFormat(tempPassword)) {
				if(this.login.correctPassword(tempCpf, tempPassword)) {
					
					this.login.setLoggedUser(
							this.udb.getUser(tempCpf)
							);
					
					var mainMenu = new MainMenu(this.login);	
					mainMenu.run();
					
					break;
				}
				else { Graphic.printMsgIncorrectPassword(); }
			}
			else { Graphic.printMsgInvalidFormat(); }
		}
	}

}
