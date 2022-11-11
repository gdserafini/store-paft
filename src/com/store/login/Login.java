package com.store.login;

import com.store.database.db.UsersDB;
import com.store.lib.Lib;
import com.store.user.User;

public class Login {
	
	private User user;
	private static final UsersDB udb = new UsersDB();
	
	public boolean validCpfFormat(String cpf){
		Lib.validsArgs(cpf);
        if(cpf.length() == 11 && 
        		onlyInt(cpf) || 
        		cpf.equals("admin")) return true;
        return false;

    }
	
	private boolean onlyInt(String cpf){
		Lib.validsArgs(cpf);
        for(char letter : cpf.toCharArray()){
            if(!Character.isDigit(letter)) return false;
        }

        return true;

    }
	
	public boolean cpfExists(String cpf) {
		Lib.validsArgs(cpf);
		
		if(this.udb.getUser(cpf) == null) return false;
		return true;
	}
	
	public boolean validPasswordFormat(String cpf){
		Lib.validsArgs(cpf);

        if(cpf.length() >= 8 && hasUpper(cpf)) return true;
        if(cpf.equals("admin")) return true;
        return false;

    }

    private boolean hasUpper(String cpf){
    	Lib.validsArgs(cpf);

        for(Character letter : cpf.toCharArray()){
            if(Character.isUpperCase(letter)) return true;
        }

        return false;

    }
	
	public boolean correctPassword(String cpf, String password) {
		Lib.validsArgs(cpf, password);
		
		if(this.udb.getUser(cpf).getPassword().equals(password)) return true;
		return false;
	}
	
	public void setLoggedUser(String cpf) {
		Lib.validsArgs(cpf);
		this.user = this.udb.getUser(cpf);
	}
	
	public void setLoggedUser(User user) {
		Lib.validsArgs(user);
		this.user = user;
	}
	
	public User getLoggedUser() { return this.user;	}

}
