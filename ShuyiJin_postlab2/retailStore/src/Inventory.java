
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Inventory {
	private Tool tool;
	private Supplier supplier;
	private int quantity;
	private Order order;

	
	public void addTool(Tool tool){
		BufferedWriter bw = null;
		FileWriter fw = null;
		try{
			File file = new File("items.txt");
			String data = Integer.toString(tool.getID()) + "," + tool.getName() + ",";
			data += Integer.toString(tool.getQuantity()) + "," + Double.toString(tool.getPrice());
			data += Integer.toString(tool.getSupplierID());
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
		}catch(IOException ex){
			ex.printStackTrace(System.err);
		}finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace(System.err);

			}
		}
	}
	
	public void deleteTool(Tool tool) {
		try {
			File file = new File("items.txt");
			File tempFile = new File("temp.txt");
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
			
			String data = Integer.toString(tool.getID()) + "," + tool.getName() + ",";
			data += Integer.toString(tool.getQuantity()) + "," + Double.toString(tool.getPrice());
			data += Integer.toString(tool.getSupplierID());
			String currentLine;
			
			while((currentLine = br.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(data)) 
					continue;
				bw.write(currentLine + System.getProperty("line.seperator"));
			}
			bw.close();
			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public OrderList createOrderList(Order order, String date) {
		System.out.println("Order list of " + date + ":");
		OrderList ol = new OrderList(order, date);
		ol.generateID();
		ol.printToFile(order);
		return ol;
	}
	
	public Order orderTool(Tool item, int quant) {
		Order newOrder = new Order(quant);
		newOrder.setDescription(item.getName());
		Supplier sup = this.searchSupplierByID(item.getSupplierID());
		newOrder.setSupplier(sup.getName());
		return newOrder;
	}
	
	public void checkToolQuantity(Tool item) {
		if (item.getQuantity() < 40) System.out.println("Not enough storage.");
	}
	
	public Tool searchToolByID(int id) {
		File file = new File("items.txt");
		String name = " ";
		int quant = 0,supID = 0;
		double price = 0.0;
		Scanner scan;
		try {
			scan = new Scanner(file);
			while(scan.hasNext()) {
				final String lineFromFile = scan.nextLine();
				if(lineFromFile.contains(Integer.toString(id))) {
					String[] temp = lineFromFile.split(";");
					name = temp[1];
					quant = Integer.parseInt(temp[2]);
					price = Double.parseDouble(temp[3]);
					supID = Integer.parseInt(temp[4]);
					break;
				}
			}	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			System.out.println(" cannot write to file " + file.toString());
		}
		
		Tool tool = new Tool(id, name, quant, price, supID);
		return tool;
	}
	
	public Tool searchToolByName(String name) {
		File file = new File("items.txt");
		int id = 0, quant = 0,supID = 0;
		double price = 0.0;
		Scanner scan;
		try {
			scan = new Scanner(file);
			String lineFromFile = " ";
			while(scan.hasNext()) {
				lineFromFile = scan.nextLine();
				if(lineFromFile.contains(name)) {
					String[] temp = lineFromFile.split(";");
					id = Integer.parseInt(temp[0]);
					quant = Integer.parseInt(temp[2]);
					price = Double.parseDouble(temp[3]);
					supID = Integer.parseInt(temp[4]);
					break;
				}
			}	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			System.out.println(" cannot write to file " + file.toString());
		}
		
		Tool tool = new Tool(id, name, quant,price,supID);
		return tool;
	}
	
	public Supplier searchSupplierByID(int id) {
		File file = new File("suppliers.txt");
		String name = " ", address = " ", contact = " ";
		Scanner scan;
		try {
			scan = new Scanner(file);
			while(scan.hasNext()) {
				final String lineFromFile = scan.nextLine();
				if(lineFromFile.contains(Integer.toString(id))) {
					String[] temp = lineFromFile.split(";");
					name = temp[1];
					address = temp[2];
					contact = temp[3];
					break;
				}
			}	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			System.out.println(" cannot write to file " + file.toString());
		}
		
		Supplier sup = new Supplier(name, address, contact, id);
		return sup;
	}
	
	public static void main(String[] args)  {
		Inventory inv = new Inventory();
		
		// date 1: January 18, 2016
		String date1 = "January 18, 2016";
		
		Tool tool1 = inv.searchToolByName("Nic Nacs");
		System.out.println("Quantity of " + tool1.getName() + " is " + tool1.getQuantity());
		Tool tool2 = inv.searchToolByID(1005);
		System.out.println("Quantity of " + tool2.getName() + " is " + tool2.getQuantity());
		
		// order 250 tool1
		Order order1 = inv.orderTool(tool1, 250);
		OrderList ol1 = inv.createOrderList(order1, date1);
		
		// order 50 tool2
		Order order2 = inv.orderTool(tool2, 50);
		ol1.addOrder(order2);
		
		// date2: January 26, 2016
		String date2 = "January 26, 2016";
		
		Tool tool3 = inv.searchToolByName("Wog Wits");
		System.out.println("\nQuantity of " + tool3.getName() + " is " + tool3.getQuantity());
		
		
		// order 100 tool3
		Order order3 = inv.orderTool(tool3, 100);
		OrderList ol2 = inv.createOrderList(order3, date2);
	}
}
