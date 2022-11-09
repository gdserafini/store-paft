package com.store.lib;

public class Lib {
	
	public static boolean invalidArgs(Object...objects) {
		for(Object obj : objects) {
			if(obj == null) return true;
		}
		return false;
	}
	
	public static void validsArgs(Object...objects) {
		if(invalidArgs(objects)) {
			throw new IllegalArgumentException("Argumentos inválidos");
		}
	}

}
