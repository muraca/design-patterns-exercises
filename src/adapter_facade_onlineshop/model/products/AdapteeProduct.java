package adapter_facade_onlineshop.model.products;

public class AdapteeProduct {
	
	private String nameOfProduct;
	private float priceOfProduct;
	private int idOfProduct;
	
	public AdapteeProduct(String name, float price, int id) {
		nameOfProduct = name;
		priceOfProduct = price;
		idOfProduct = id;
	}
	
	String getNameOfProduct() {
		return nameOfProduct;
	}
	float getPriceOfProduct() {
		return priceOfProduct;
	}
	int getIDOfProduct() {
		return idOfProduct;
	}
}
