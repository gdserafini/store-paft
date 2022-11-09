package com.store.user.users;

import com.store.lib.Lib;
import com.store.user.Authenticable;
import com.store.user.User;

public class Admin extends User implements Authenticable, Comparable<User> {
	
	private final int purchases = 0;

	public Admin() {
		super("admin", "admin", "admin");
	}

	@Override
	public boolean isAuthenticable() { return true;	}

	@Override
	public boolean isAdmin() { return true; }
	
	@Override 
	public String toString() { return "\nUser: Admin"; }
	
	@Override 
	public int compareTo(User user) {
		Lib.validsArgs(user);
		return ((Client)user).getPurchases() - this.purchases;
	}

}
