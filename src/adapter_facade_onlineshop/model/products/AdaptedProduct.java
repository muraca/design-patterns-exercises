package adapter_facade_onlineshop.model.products;

public class AdaptedProduct implements Product {
	
	private AdapteeProduct adaptee;
	
	public AdaptedProduct(String name, float price) {
		adaptee = new AdapteeProduct(name, price, name.hashCode());
	}
	
	public AdaptedProduct(String name, float price, int id) {
		adaptee = new AdapteeProduct(name, price, id);
	}
	
	public AdaptedProduct(AdapteeProduct original) {
		adaptee = original;
	}

	@Override
	public String getName() {
		return adaptee.getNameOfProduct();
	}

	@Override
	public float getPrice() {
		return adaptee.getPriceOfProduct();
	}

	@Override
	public boolean equals(Product p) {
		return getName().equalsIgnoreCase(p.getName()) && getPrice() == p.getPrice();
	}
	
	@Override
	public String toString() {
		return print();
	}

}
