package command_memento_restaurant;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;

import command_memento_restaurant.model.Dish;
import command_memento_restaurant.view.RestaurantPanel;

public class Restaurant {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Restaurant");
		
		f.add(new RestaurantPanel());
		
		f.setVisible(true);
		f.setSize(500,250);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static HashMap<String, Dish> dishes;
	private static Vector<String> dishesNames = null;
	
	public static Vector<String> getDishesNames() {
		if (dishesNames == null) {
			dishes = new HashMap<>();
			dishesNames = new Vector<>();
			dishesNames.add("pasta asciutta");
			dishesNames.add("carbonara");
			dishesNames.add("amatriciana");
			dishesNames.add("grigliata di carne");
			dishesNames.add("fritto misto di pesce");
			dishesNames.add("insalata di mare");
			dishesNames.add("parmigiana");
			
			for(String n: dishesNames) {
				dishes.put(n, new Dish(n, n.length(), n.length()/2));
			}
		}
		
		return dishesNames;
	}
	
	public static Dish getDish(String dishName) {
		return dishes.get(dishName);
	}
	
	public float getPrice(String dishName) {
		return dishes.get(dishName).getPrice();
	}
	
	public int getCookingTime(String dishName) {
		return dishes.get(dishName).getCookingTime();
	}
}
