
public class Supplier {
	private String name;
	private String address;
	private String contact;
	private int id;
	
	public Supplier(String name, String address, String contact, int id) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
}
