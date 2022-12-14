package com.store.user.users;

import com.store.lib.Lib;
import com.store.user.User;

public class Client extends User implements Comparable<User>{
	
	private int purchases;
	private double totalValue;
	
	public Client(String cpf, String name, String password) {
		super(cpf, name, password);
	}
	
	public int getPurchases() { return this.purchases; }
	
	public double getTotalValue() { return this.totalValue; }
	
	public void setPurchases(int purchases) {
		Lib.validsArgs(purchases);
		if(purchases < 0) this.purchases = 0;
		else this.purchases = purchases;
	}
	
	public void setTotalValue(double totalValue) {
		Lib.validsArgs(totalValue);
		if(totalValue < 0) this.totalValue = 0;
		else this.totalValue = totalValue;
	}
	
	@Override
	public String toString() {
		return String.format("\nNome: %s\nN° de compras: %d\nTotal: R$ %.2f", 
				super.getName(), this.purchases, this.totalValue);
	}
	
	@Override
	public int compareTo(User user) {
		Lib.validsArgs(user);
		return ((Client)user).getPurchases() - this.purchases;
	}

}
