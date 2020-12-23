package adapter_facade_onlineshop.model.products;

public interface Product {
	public String getName();
	public float getPrice();
	public boolean equals(Product p);
	public default String print() {
		return getName() + " €" + getPrice();
	}
}
