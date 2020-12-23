package adapter_facade_onlineshop.model.products;

import java.util.ArrayList;

public class ProductsManager {
	private static ProductsManager instance = null;
	
	public static void init() {
		if(instance == null)
			instance = new ProductsManager();
	}
	
	private ArrayList<Product> products;
	
	private ProductsManager() {
		products = new ArrayList<>();
		products.add(new ConcreteProduct("iPhone 12 mini", 899));
		products.add(new ConcreteProduct("Galaxy S20", 699));
		products.add(new ConcreteProduct("Huawei P40", 799));

		products.add(new AdaptedProduct("MacBook Pro 13", 1299, 2107));
		products.add(new AdaptedProduct(new AdapteeProduct("MacBook Pro 16", 1699, 2109)));
		products.add(new AdaptedProduct("Dell G5", 1530.39f));
		
	}
	
	public static ArrayList<Product> getProducts() {
		init();
		return instance.products;
	}
	
	public static void printProducts() {
		if(instance.products.size() == 0) {
			System.out.println("Looks like we have a problem here...");
		}
		else {
			for(int i = 0; i < instance.products.size(); i++) 
				System.out.println(i+1 + ": " + instance.products.get(i).toString());
		}
	}
}
