package com.store.login;

import com.store.database.db.UsersDB;
import com.store.user.User;

public class Login {
	
	private User user;
	
	public boolean validCpfFormat(String cpf){

        if(cpf == null || cpf.length() == 0){
            throw new IllegalArgumentException("Cpf indefinido.");
        }
        
        if(cpf.length() == 11 && onlyInt(cpf) || cpf.equals("admin")) return true;
        return false;

    }
	
	private boolean onlyInt(String cpf){

        for(char letter : cpf.toCharArray()){
            if(!Character.isDigit(letter)) return false;
        }

        return true;

    }
	
	public boolean cpfExists(String cpf) {
		
		if(cpf == null || cpf.length() == 0){
            throw new IllegalArgumentException("Cpf indefinido.");
        }
		
		var udb = new UsersDB();
		
		if(udb.getUser(cpf) == null) return false;
		return true;
	}
	
	public boolean validPasswordFormat(String cpf){

        if(cpf.length() == 0 || cpf == null){
            throw new IllegalArgumentException("CPF indefinido.");
        }

        if(cpf.length() >= 8 && hasUpper(cpf)) return true;
        if(cpf.equals("admin")) return true;
        return false;

    }

    private boolean hasUpper(String cpf){

        for(Character letter : cpf.toCharArray()){
            if(Character.isUpperCase(letter)) return true;
        }

        return false;

    }
	
	public boolean correctPassword(String cpf, String password) {
		
		if(cpf == null || cpf.length() == 0 || password == null || password.length() == 0){
            throw new IllegalArgumentException("Dados indefinidos.");
        }
		
		var udb = new UsersDB();
		
		if(udb.getUser(cpf).getPassword().equals(password)) return true;
		return false;
	}
	
	public void setLoggedUser(String cpf) {
		
		if(cpf.length() == 0 || cpf == null){
            throw new IllegalArgumentException("CPF indefinido.");
        }
		
		var udb = new UsersDB();
		
		this.user = udb.getUser(cpf);
	}
	
	public void setLoggedUser(User user) {
		
		if(user == null){
            throw new IllegalArgumentException("User indefinido.");
        }
		
		this.user = user;
	}
	
	public User getLoggedUser() { return this.user;	}

}
