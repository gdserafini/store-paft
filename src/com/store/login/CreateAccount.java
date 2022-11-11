package com.store.login;

import java.util.Scanner;

import com.store.database.db.UsersDB;
import com.store.graphic.Graphic;
import com.store.lib.Lib;

public class CreateAccount {
	
	private Login login;
	private static final Scanner scan = new Scanner(System.in);
	private static final UsersDB udb = new UsersDB();
	
	public CreateAccount(Login login) {
		Lib.invalidArgs(login);
		this.login = login;
	}
	
	public void create(String cpf, String name) {
		Lib.invalidArgs(cpf, name);
		
		while(true) {
			
			Graphic.printMsgCreatePassword();
			var tempPassword = scan.nextLine();
			
			if(this.login.validPasswordFormat(tempPassword)) {
				
				if(this.udb.createUser(cpf, name, tempPassword)) {
					Graphic.printMsgAccountCreated();
				}
				else { Graphic.printMsgCreateError(); }
				break;
			}
			else { Graphic.printMsgInvalidFormat(); }
		}
		
	}

}
