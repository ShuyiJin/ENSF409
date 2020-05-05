
public class Order {
	private int quantity;
	private String supplier;
	private String description;
	
	public Order(int amount) {
		quantity = amount;
		String supplier = " ";
		String description = " ";
	}
	
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public String getSupplier(){
		return supplier;
	}
		
	public void setDescription(String description) {
		this.description = description; 
	}
}
