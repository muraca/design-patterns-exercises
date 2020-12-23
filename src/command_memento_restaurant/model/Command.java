package command_memento_restaurant.model;

public abstract class Command {
	OrderManager manager;
	public Command(OrderManager manager) {
		this.manager = manager;
	}
	
	public abstract void execute();
}
