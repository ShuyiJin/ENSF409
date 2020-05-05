import java.util.Scanner;

public class MDArray{
	public static void main(String[] args){
		
		char[][] message = new char[3][];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++){
			System.out.printf("Please enter massage " + (i+1) + ":\n");
			String temp = scan.nextLine();
			message[i] = temp.toCharArray();
		}
		
		// The first sentence
		int size = message[0].length;
		char[] line1 = new char[size];
		for(int j = 0; j < size; j++){
			line1[j] = message[0][size - 1 - j];
		}
		System.out.println(line1);
		
		//The second sentence
		size = message[1].length;
		char[] line2 = new char[size];
		int newIndex = 0;
		int startIndex = size - 1;
		int endIndex = 0;
		for(int i = size - 1; i >= 0; i--){
			if (Character.isWhitespace(message[1][i])){
				endIndex = i;
				for(int j = 0; j < (startIndex - endIndex); j++){
					line2[newIndex + j] = message[1][j + 1 + endIndex];
				}
				newIndex += (startIndex - endIndex + 1);
				startIndex = i - 1;
			}	
			else if (i == 0){
				for(int j = 0; j < startIndex + 1; j++)
					line2[j + newIndex] = message[1][j];
			}
		}
		System.out.println(line2);
		
		size = message[2].length;
		char[] line3 = new char[size];
		for(int i = 0; i < size; i++){
			if(i%5 == 0){
				line3[i] = Character.toUpperCase(message[2][i]);
				
			}
				
			else
				line3[i] = message[2][i];
		}
		System.out.println(line3);
	}
}