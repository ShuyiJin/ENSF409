
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class OrderList {
	private int orderID;
	private String date;
	private Order item;
	private String fileName;
	
	public void generateID() {
		orderID = (int) Math.round(Math.random() * 89999) + 10000;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public OrderList(Order order, String date) {
		item = order;
		fileName = "Order" + date + ".txt";
		this.setDate(date);
	}
	
	public void printToFile(Order order) {
		BufferedWriter bw = null;
		try {
			File file = new File(fileName);
			bw = new BufferedWriter(new FileWriter(fileName));
			String text = "****************************************************************";
			bw.write(text);
			text = "ORDER ID:			" + Integer.toString(orderID);
			bw.write(text);
			text = "Date Ordered:		" + date;
			bw.write(text);
			bw.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void addOrder(Order item) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			String text = " ";
			bw.write(text);
			text = "Item Description:	" + item.getDescription();
			bw.write(text);
			text = "Amount Ordered:		" + Integer.toString(item.getQuantity());
			bw.write(text);
			text = "Supplier:			" + item.getSupplier();
			bw.write(text);
			bw.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
