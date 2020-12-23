package adapter_facade_onlineshop.model.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import adapter_facade_onlineshop.model.products.Product;
import adapter_facade_onlineshop.model.products.ProductsManager;

public class OrderManager implements Facade {

	private String username;
	private float discount;
	private CartManager c;
	private ArrayList<Product> products;
	
	public OrderManager(String user, float disc, int ccn) {
		username = user;
		discount = disc;
		c = new CartManager();
		products = ProductsManager.getProducts();
	}
	
	@Override
	public void makeOrder() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean session = true;
		do {
			System.out.println("");
			System.out.println("1: check list of products");
			System.out.println("2: add products to your cart");
			System.out.println("3: remove products from your cart");
			System.out.println("4: erase your cart");
			System.out.println("5: check your cart");
			System.out.println("6: checkout");
			System.out.println("0: exit");
			System.out.print("Insert your choice: ");
			int choice = 0;
			String input = null;
			try {
				input = reader.readLine();
				choice = Integer.parseInt(input);
				
				switch (choice) {
				case 1:
					ProductsManager.printProducts();
					break;
				case 2:
					System.out.print("Insert product number: ");
					input = reader.readLine();
					int prodn = Integer.parseInt(input);
					System.out.print("Insert product quantity: ");
					input = reader.readLine();
					int prodq = Integer.parseInt(input);
					if(prodn > 0 && prodn <= products.size())
						for(int i = 0; i < prodq; i++)
							c.addToCart(ProductsManager.getProducts().get(prodn-1));
					else
						System.out.println("Invalid! Try again.");
					break;
				case 3:
					c.printCart();
					System.out.print("Insert product id: ");
					input = reader.readLine();
					int id = Integer.parseInt(input);
					c.removeFromCart(id);
					break;
				case 4:
					c.clearCart();
					break;
				case 5:
					c.printCart();
					break;
				case 6:
					float totalPrice = c.getTotalPrice();
					int totalQuantity = c.getTotalQuantity();
					if(totalQuantity == 0) {
						System.out.println("Your cart is empty...");
						break;
					}
					c.clearCart();
					float discountedPrice = DiscountManager.makeDiscount(totalPrice, discount);
					ShipmentsManager.makeAndShipPackage(discountedPrice, totalQuantity, username);
					System.out.println("Packaged and ready for shipment.\nCheck your shipments from the main page.");
					break;

				case 0:
					session = false;
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
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void checkShipments() {
		ShipmentsManager.showShipmentsForUser(username);

	}
	
	public String getUsername() {
		return username;
	}


}
