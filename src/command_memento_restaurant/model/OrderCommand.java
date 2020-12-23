package command_memento_restaurant.model;

import javax.swing.JOptionPane;

import command_memento_restaurant.Restaurant;

public class OrderCommand extends Command {

	private Dish dishToOrder;

	public OrderCommand(OrderManager manager) {
		super(manager);
	}
	
	public void setDishToOrder(String toOrder) {
		dishToOrder = Restaurant.getDish(toOrder);
	}

	@Override
	public void execute() {
		try {
			Thread.sleep(dishToOrder.getCookingTime()*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ok = JOptionPane.showConfirmDialog(null, "do you want to eat "+dishToOrder.getName()+"?", "order arrived!", JOptionPane.YES_NO_OPTION);
		manager.add(dishToOrder, ok == 0);
	}

}
