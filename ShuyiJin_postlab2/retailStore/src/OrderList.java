
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class OrderList {
	private int orderID;
	private String date;
//	private Order item;
	private String fileName;
	
	public OrderList(Order order, String date) {
//		item = order;
		fileName = "Order - " + date + ".txt";
		this.setDate(date);
	}
	
	public void generateID() {
		orderID = (int) Math.round(Math.random() * 89999) + 10000;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void printToFile(Order order) {
		BufferedWriter bw = null;
		try {
			File file = new File(fileName);
			bw = new BufferedWriter(new FileWriter(fileName));
			String text = "****************************************************************\n";
			bw.write(text);
			System.out.printf(text);
			text = "ORDER ID: \t\t" + Integer.toString(orderID) + "\n";
			bw.write(text);
			System.out.printf(text);
			text = "Date Ordered: \t\t" + date + "\n";
			bw.write(text);
			System.out.printf(text);
			bw.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		this.addOrder(order);
	}
	
	public void addOrder(Order item) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			String text = "\n";
			bw.write(text);
			System.out.printf(text);
			text = "Item Description: \t" + item.getDescription() + "\n";
			System.out.printf(text);
			bw.write(text);
			text = "Amount Ordered:	\t" + Integer.toString(item.getQuantity()) + "\n";
			System.out.printf(text);
			bw.write(text);
			text = "Supplier: \t\t" + item.getSupplier() + "\n";
			bw.write(text);
			System.out.printf(text);
			bw.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
