package command_memento_restaurant.model;

public class Dish {
	
	private String name;
	private float price;
	private int cookingTime;

	public Dish(String name, float price, int cookingTime) {
		this.name = name;
		this.price = price;
		this.cookingTime = cookingTime;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getCookingTime() {
		return cookingTime;
	}
	
}
