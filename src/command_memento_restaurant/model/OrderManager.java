package command_memento_restaurant.model;

import java.util.Vector;

public class OrderManager {
	
	private Vector<OrderMemento> mementos;
	
	private class OrderMemento {
		
		Dish dish;
		boolean eaten;

		OrderMemento(Dish dish, boolean eaten) {
			this.dish = dish;
			this.eaten = eaten;
		}
	}
	
	private static OrderManager instance;
	
	public static OrderManager getInstance() {
		if (instance == null)
			instance = new OrderManager();
		return instance;
	}
	
	private OrderManager() {

		mementos = new Vector<>();
	}

	public void add(Dish dishToOrder, boolean b) {
		mementos.add(new OrderMemento(dishToOrder, b));
		
	}

	boolean rollback() {
		if(mementos.size() == 0)
			return false;
		if (mementos.get(mementos.size() -1).eaten)
			return false;
		mementos.remove(mementos.size() -1);
		return true;
	}
	
	float getTotalCost() {
		float total = 0;
		for (OrderMemento o: mementos) {
				total += o.dish.getPrice();
		}
		return total;
	}

	public void clear() {
		mementos.clear();
		
	}

}
