package com.store.user;

public abstract class User implements Comparable<User>{
	
	private String cpf;
	private String name;
	private String password;
	
	public User(String cpf, String name, String password) {
		this.cpf = cpf;
		this.name = name;
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int compareTo(User user) {
		return this.name.compareTo(user.getName());
	}

}
