
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
	
	public void createOrderList(Order order, String date) {
		OrderList ol = new OrderList(order, date);
		ol.generateID();
		ol.printToFile(order);
	}
	
	public void orderTool(Tool item, int quant) {
		Order newOrder = new Order(quant);
		newOrder.setDescription(item.getName());
	}
	
	public void checkToolQuantity() {
		
	}
	
	public Tool searchToolByID(int id) {
		File file = new File("items.txt");
		String name = " ";
		int quant = 0,supID = 0;
		double price = 0.0;
		Scanner scan;
		try {
			scan = new Scanner(file).useDelimiter(";");
			while(scan.hasNext()) {
				final String lineFromFile = scan.nextLine();
				if(lineFromFile.contains(Integer.toString(id))) {
					name = scan.nextLine();
					quant = Integer.parseInt(scan.nextLine());
					price = Double.parseDouble(scan.nextLine());
					supID = Integer.parseInt(scan.nextLine());
					break;
				}
			}	
		}
		catch(IOException ex) {
			System.out.println(" cannot write to file " + file.toString());
		}
		
		Tool tool = new Tool(id, name, quant,price,supID);
		return tool;
	}
	
	public Tool searchToolByName(String name) {
		File file = new File("items.txt");
		int id = 0, quant = 0,supID = 0;
		double price = 0.0;
		Scanner scan;
		try {
			scan = new Scanner(file).useDelimiter(";");
			String lineFromFile = " ";
			while(scan.hasNext()) {
				String temp = lineFromFile;
				lineFromFile = scan.nextLine();
				if(lineFromFile.contains(name)) {
					id = Integer.parseInt(temp);
					quant = Integer.parseInt(scan.nextLine());
					price = Double.parseDouble(scan.nextLine());
					supID = Integer.parseInt(scan.nextLine());
					break;
				}
			}	
		}
		catch(IOException ex) {
			System.out.println(" cannot write to file " + file.toString());
		}
		
		Tool tool = new Tool(id, name, quant,price,supID);
		return tool;
	}
	
	public static void main(String[] args)  {
		
	}
}
