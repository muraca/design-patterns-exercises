package adapter_facade_onlineshop.model.Facade;

import java.util.ArrayList;

public class ShipmentsManager {
	
	private static ShipmentsManager instance = null;
	
	private static void init() {
		if(instance == null)
			instance = new ShipmentsManager();
	}
	
	private ArrayList<Shipment> shipments;
	
	private ShipmentsManager() {
		shipments = new ArrayList<>();
	}

	public static void makeAndShipPackage(float totalPrice, int totalQuantity, String username) {
		init();
		instance.shipments.add(new Shipment(instance.shipments.size(), totalQuantity, totalPrice, username));	
		instance.shipments.get(instance.shipments.size() -1).ship();
	}
	
	public static void showAllShipments () {
		init();
		if(instance.shipments.isEmpty())
			System.out.println("No shipments in the system");
		for(Shipment s: instance.shipments)
			System.out.println(s.toString());	
	}
	
	public static void showShipmentsForUser (String username) {
		init();
		if(instance.shipments.isEmpty()) {
			System.out.println("No shipments in the system");
			return;
		}
		boolean found = false;
		for(Shipment s: instance.shipments) {
			if(username.equalsIgnoreCase(s.getDestination())) {
				System.out.println(s.toString());
				found = true;
			}
		}
		if(!found)
			System.out.println("No shipments for user " + username);
		
	}
	
}
