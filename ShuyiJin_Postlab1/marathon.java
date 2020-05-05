import java.util.Scanner;

public class Marathon{
	
	public static void main(String[] args){
		String sin;
		Scanner scan = new Scanner(System.in);
		
		String[] names = new String[100];
		int[] times = new int[100];
		int index = 0;
		
		while(true){
			System.out.println("Please enter the name of the participant");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			
			names[index] = sin; // Add the name to your ArrayList
			
			System.out.println("Please enter the running time of the participant");
			sin = scan.nextLine();
			
			times[index] = Integer.parseInt(sin); // Add trhe running time to your ArrayList
			index++;
			
			if(index == 100) break;
		}
		// Call the function findFastestRunner and pass the running times array list to it
		
		// Print the name of the fastestRunner to the console
		
		
		Marathon item = new Marathon();
		int fastestRunner = item.findFastestRunner(times, index);
		System.out.printf("The fastest runner is %s and the time is %d.\n", names[fastestRunner], times[fastestRunner]);
	}
	
	public int findFastestRunner(int[] timeArray, int index){
		int fastest = timeArray[0];
		int fastestIndex = 0;
		for(int i = 1; i < index; i++){
			if(timeArray[i] < fastest){
				fastest = timeArray[i];
				fastestIndex = i;
			}
		}
		return fastestIndex;
	}
}