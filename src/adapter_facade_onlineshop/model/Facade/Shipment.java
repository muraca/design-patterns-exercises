package adapter_facade_onlineshop.model.Facade;

public class Shipment {
	private int id;
	private int quantity;
	private float price;
	private String destination;
	private boolean shipped = false;
	private boolean delivered = false;
	
	public Shipment (int id, int quantity, float price, String user) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.destination = user;
	}
	
	public void ship() {
		if(java.time.LocalTime.now().getHour() > 8 && java.time.LocalTime.now().getHour() < 16)
		shipped = true;
	}
	
	public boolean isShipped() {
		return shipped;
	}
	
	public boolean isDelivered() {
		return delivered;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String toString() {
		return "Order Number " + id + " containing " + quantity + " items, costing €"
				+ price + (delivered ? (" have been delivered to "+ destination + ".") : 
					(shipped ? (" have been shipped to " + destination + ".") :
						(" haven't been shipped yet.")));
						
	}
	
}
