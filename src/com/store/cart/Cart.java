package com.store.cart;

import java.util.ArrayList;
import java.util.List;
import com.store.product.Product;

public class Cart {
	
	private List<Product> products = new ArrayList<>();
	
	public void printCart() {
		
		this.products.stream()
			.sorted()
			.forEach(System.out::println);
		
	}
	
	public void addProduct(Product product, int amount) {
		
		if(product == null) {
			throw new IllegalArgumentException("Produto indefinido.");
		}
		
		for(int i = 0; i < amount; i++) {
			this.products.add(product);
		}
		
	}
	
	public void removeProduct(Product product) {
		
		if(product == null) {
			throw new IllegalArgumentException("Produto indefinido.");
		}
		
		this.products.remove(product);
		
	}
	
	public void removeProduct(String name) {
		this.products.removeIf(p -> p.getName().equals(name));
	}
	
	public List<Product> getAllProducts(){
		return this.products;
	}
	
	public void removeAllProducts() {
		this.products.clear();
	}

}
