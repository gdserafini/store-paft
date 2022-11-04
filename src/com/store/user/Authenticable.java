package com.store.user;

public interface Authenticable {
	
	//se for um autenticável retornar true para acessar sistema interno
	public boolean isAuthenticable();
	
	//se for um admin retorna true para alterar dados da loja
	public boolean isAdmin();

}
