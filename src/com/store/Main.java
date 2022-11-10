package com.store;

import java.util.Scanner;

import com.store.database.ApiDB;
import com.store.graphic.Graphic;
import com.store.login.Login;
import com.store.login.MenuLogin;

public class Main {

	public static void main(String[] args)  {
		
		if(ApiDB.ping()) {
			Graphic.printIntro();
			
			var loginMenu = new MenuLogin(new Login());
			loginMenu.run();
			
			Graphic.printEnd();
		}
		else {
			Graphic.printMsgErrorDataBase();
		}		
	}  
}
