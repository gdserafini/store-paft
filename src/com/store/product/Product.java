package com.store.product;

public class Product implements Comparable<Product> {
	
	private String name;
	private double price;
	private int amount;
	
	public Product(String name, double price, int amount) {
		if(name == null || name.length() == 0 || price < 0 || amount < 0) {
			throw new IllegalArgumentException("Dados inválidos.");
		}
		
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		var product = String.format(
				"\nNome: %s\nPreço: R$ %.2f\nQuantidade: %d", 
				this.name, this.price, this.amount);
		return product;
	}
	
	@Override
	public int compareTo(Product product) {
		return (int)(product.getPrice() - this.price);
	}

}
