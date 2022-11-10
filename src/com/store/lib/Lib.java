package com.store.lib;

import java.util.Scanner;
import java.util.function.Consumer;

import com.store.graphic.Graphic;

public class Lib {
	
	private static final Scanner scan = new Scanner(System.in);
	
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
	
	public static boolean isNegative(Object...objects) {
		for(Object obj : objects) {
			if(obj.getClass() == String.class) {
				throw new IllegalArgumentException("Argumento inválido.");
			}
			if((int)obj < 0 || (double)obj < 0 || (float)obj < 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void validsPositiveNumbers(Object...objects) {
		if(isNegative(objects) || invalidArgs(objects)) {
			throw new IllegalArgumentException("Números inválidos.");
		}
	}

}
