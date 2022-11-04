package com.store.login;

import java.util.Scanner;

import com.store.database.db.UsersDB;
import com.store.graphic.Graphic;

public class CreateAccount {
	
	private Login login;
	private static final Scanner scan = new Scanner(System.in);
	
	public CreateAccount(Login login) {
		if(login == null) {
			throw new IllegalArgumentException("Login indefinido.");
		}
		this.login = login;
	}
	
	public void create(String cpf, String name) {
		
		while(true) {
			
			Graphic.printMsgCreatePassword();
			var tempPassword = scan.nextLine();
			
			if(this.login.validPasswordFormat(tempPassword)) {
				
				var udb = new UsersDB();
				
				if(udb.createUser(cpf, name, tempPassword)) {
					Graphic.printMsgAccountCreated();
				}
				else {
					Graphic.printMsgCreateError();
				}
				
				break;
			}
			else {
				Graphic.printMsgInvalidFormat();
			}
		}
		
	}

}
