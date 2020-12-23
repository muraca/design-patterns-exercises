package command_memento_restaurant.model;

import javax.swing.JOptionPane;

public class PayCommand extends Command {

	public PayCommand(OrderManager manager) {
		super(manager);
	}

	@Override
	public void execute() {

		JOptionPane.showMessageDialog(null, "you paid "+manager.getTotalCost()+"€", "pay", JOptionPane.INFORMATION_MESSAGE);
		manager.clear();
		
	}
	
}
