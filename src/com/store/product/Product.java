package com.store.product;

import com.store.lib.Lib;

public class Product implements Comparable<Product> {
	
	private String name;
	private double price;
	private int amount;
	
	public Product(String name, double price, int amount) {
		Lib.validsArgs(name, price, amount);
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() { return this.name; }

	public void setName(String name) {
		Lib.validsArgs(name);
		this.name = name;
	}

	public double getPrice() { return this.price; }

	public void setPrice(double price) {
		Lib.validsPositiveNumbers(price);
		this.price = price;
	}

	public int getAmount() { return this.amount; }

	public void setAmount(int amount) {
		Lib.validsPositiveNumbers(amount);
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format(
				"\nNome: %s\nPreço: R$ %.2f\nQuantidade: %d", 
				this.name, this.price, this.amount);
	}
	
	@Override
	public int compareTo(Product product) {
		Lib.validsArgs(product);
		return (int)(product.getPrice() - this.price);
	}

}
