
public class Tool {
	private int id;
	private String name;
	private int quantity;
	private double price;
	private int supplierID;
	
	public Tool(int id, String name, int quantity, double price, int supID) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.supplierID = supID;
	}
	
	public void setQuantity(int quant) {
		this.quantity = quant;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getSupplierID() {
		return supplierID;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
