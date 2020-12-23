package adapter_facade_onlineshop.model.Facade;

public class DiscountManager {
	static float makeDiscount(float price, float discount) {
		if(discount <= 0 || discount >= 100)
			return price;
		return price * (100 - discount) / 100;
	}
}
