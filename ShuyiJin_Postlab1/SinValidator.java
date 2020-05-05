import java.util.Scanner;


public class SinValidator {

	private int[] SIN;

	private int sumDigit(int x)
	{
		int result = 0;
		
		while(x > 0){
			result += x % 10;
			x = x /10;
		}
		
		return result;
	}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		int step1 = 0;
		int step2 = 0;
		int sum = 0;
		
		for (int i = 0; i <= 6; i += 2)
			step1 += this.SIN[i];
		
		for (int i = 1; i <= 7; i += 2){
			int digit = this.SIN[i] * 2;
			step2 += digit/10 + digit%10;
		}
		
		int sumLSD = (step1 + step2)%10;
        
		return (10 - sumLSD) == this.SIN[8];
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}
