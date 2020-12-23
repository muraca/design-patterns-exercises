package command_memento_restaurant.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import command_memento_restaurant.Restaurant;
import command_memento_restaurant.model.Command;
import command_memento_restaurant.model.OrderCommand;
import command_memento_restaurant.model.OrderManager;
import command_memento_restaurant.model.PayCommand;
import command_memento_restaurant.model.UndoCommand;

public class RestaurantPanel extends JPanel {

	public RestaurantPanel() {
		setLayout(null);
		
		JComboBox<String> dishesBox = new JComboBox<String>(Restaurant.getDishesNames());

		dishesBox.setBounds(50, 50, 300, 50);
		add(dishesBox);
		
		JButton orderButton = new JButton("order");
		orderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OrderCommand c = new OrderCommand(OrderManager.getInstance());
				c.setDishToOrder((String) dishesBox.getSelectedItem());
				c.execute(); 
				
		}});
		
		orderButton.setBounds(350, 50, 100, 50);
		add(orderButton);
		
		JButton undoButton = new JButton("undo");
		undoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Command c = new UndoCommand(OrderManager.getInstance());
				c.execute();
				
		}});
		
		undoButton.setBounds(75, 150, 100, 50);
		add(undoButton);
		
		JButton payButton = new JButton("pay");
		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Command c = new PayCommand(OrderManager.getInstance());
				c.execute();
				
		}});
		
		payButton.setBounds(325, 150, 100, 50);
		add(payButton);
		
	}

	private static final long serialVersionUID = -2311353264818472932L;
	
}
