package com.store.main.is;

import com.store.database.db.UsersDB;
import com.store.graphic.Graphic;

public class Relatory {
	
	public void printUsers() {
		
		var udb = new UsersDB();
		
		var listUsers = udb.getAllUsers();
		
		if(listUsers.size() == 0) Graphic.printMsgEmpty();
		else listUsers.stream().sorted().forEach(System.out::println);
		
	}

}
