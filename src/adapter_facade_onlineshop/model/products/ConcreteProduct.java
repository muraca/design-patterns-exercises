package adapter_facade_onlineshop.model.products;

public class ConcreteProduct implements Product {
	private String name;
	private float price;
	
	public ConcreteProduct (String n, float p) {
		name = n;
		price = p;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public boolean equals(Product p) {
		return name.equalsIgnoreCase(p.getName()) && price == p.getPrice();
	}
	
	@Override
	public String toString() {
		return print();
	}

}
