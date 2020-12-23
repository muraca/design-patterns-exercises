package command_memento_restaurant.model;

import javax.swing.JOptionPane;

public class UndoCommand extends Command {

	public UndoCommand(OrderManager manager) {
		super(manager);
	}

	@Override
	public void execute() {
		if (manager.rollback()) 
			JOptionPane.showMessageDialog(null, "the order was successfully removed", "undo", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "you cannot remove a order you have already eaten", "undo", JOptionPane.ERROR_MESSAGE);

	}

}
