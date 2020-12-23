package adapter_facade_onlineshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import adapter_facade_onlineshop.model.Facade.OrderManager;

public class MyShop {
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<OrderManager> managers = new ArrayList<>();
		boolean running = true;
		while(running) {
			System.out.print("Insert username: ");
			String username = null;
			try {
				username = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			int index = -1;
			for(int i = 0; i < managers.size(); i++) {
				if(managers.get(i).getUsername() == username) {
					index = i;
				}
			}
			if(index < 0) {
				float discount = 0;
				System.out.print("Do you have a discount code? Y for yes: ");
				String input = null;
				try {
					input = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(input.equalsIgnoreCase("y")) {
					System.out.print("Insert discount code: ");
					try {
						input = reader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(input.equalsIgnoreCase("michele10"))
						discount = 10;
					else if(input.equalsIgnoreCase("matteo20"))
						discount = 20;
					else if(input.equalsIgnoreCase("codicemagico"))
						discount = 99;
				}
				
				System.out.print("Insert your CC number: ");
				int ccn = 0;
				boolean tryagain = false;
				do {
					try {
						input = reader.readLine();
						ccn = Integer.parseInt(input);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (NumberFormatException e1) {
						tryagain = true;
						System.out.print("Invalid! Try again: ");
					}
				} while(tryagain);
					
				managers.add(new OrderManager(username, discount, ccn));
				index = managers.size() - 1;
				System.out.println("Welcome, " + username + "!");
			}
			else {
				System.out.println("Welcome back, " + username + "!");
			}
			
			boolean session = true;
			do {
				System.out.println("1: place an order");
				System.out.println("2: check your shipments");
				System.out.println("9: logout");
				System.out.println("0: exit");
				System.out.print("Insert your choice: ");
				int choice = 0;
				String input = null;
				try {
					input = reader.readLine();
					choice = Integer.parseInt(input);
					
					switch (choice) {
					case 1:
						managers.get(index).makeOrder();
						break;
					case 2:
						managers.get(index).checkShipments();
						break;
					case 9:
						session = false;
						break;
					case 0:
						session = false;
						running = false;
						break;
					default:
						System.out.println("Invalid! Try again.");
						break;
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e1) {
					System.out.println("Invalid! Try again.");
				}
			} while(session);
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
