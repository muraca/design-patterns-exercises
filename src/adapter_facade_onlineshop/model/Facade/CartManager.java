package adapter_facade_onlineshop.model.Facade;

import java.util.ArrayList;

import adapter_facade_onlineshop.model.products.Product;

public class CartManager {
	private ArrayList<Product> products;
	
	public CartManager() {
		products = new ArrayList<>();
	}
	
	public void addToCart(Product p) {
		products.add(p);
	}
	
	public void removeFromCart(int p) {
		if(p > 0 && p <= products.size())
			products.remove(p-1);
	}
	
	public void clearCart() {
		products.clear();
	}
	
	public void printCart() {
		if(products.size() == 0) {
			System.out.println("Your cart is empty...");
		}
		else {
			for(int i = 0; i < products.size(); i++) 
				System.out.println(i+1 + ": " + products.get(i).toString());
		}
	}
	
	public float getTotalPrice() {
		float total = 0;
		for(int i = 0; i < products.size(); i++)
			total += products.get(i).getPrice();
		return total;
	}
	
	public int getTotalQuantity() {
		return products.size();
	}
}
