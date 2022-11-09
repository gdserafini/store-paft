package com.store.user;

import com.store.lib.Lib;

public abstract class User implements Comparable<User>{
	
	private String cpf;
	private String name;
	private String password;
	
	public User(String cpf, String name, String password) {
		Lib.validsArgs(cpf, name, password);
		this.cpf = cpf;
		this.name = name;
		this.password = password;
	}

	public String getCpf() { return this.cpf; }

	public void setCpf(String cpf) { 
		Lib.validsArgs(cpf);
		this.cpf = cpf; 
	}

	public String getName() { return this.name; }

	public void setName(String name) {
		Lib.validsArgs(name);
		this.name = name;
	}

	public String getPassword() { return this.password; }

	public void setPassword(String password) {
		Lib.validsArgs(password);
		this.password = password;
	}
	
	@Override
	public int compareTo(User user) {
		Lib.validsArgs(user);
		return this.name.compareTo(user.getName());
	}

}
