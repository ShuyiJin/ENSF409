
public class AverageCalculator{
	public static void main(String[] args){

		int arraySize = args.length;
		double[] array = new double[arraySize];
		double temp = 0.0;
		double sum = 0.0;
		
		for(int i = 0; i < arraySize; i++){
			temp = Double.parseDouble(args[i]);
			array[i] = temp;	
			sum += temp;
		}
		
		System.out.print("The " + arraySize + " numbers are:" );
		
		for (int i = 0; i < arraySize; i++){
			System.out.printf(" %.3f" ,array[i]);			
		}
		
		System.out.println(" ");
		
		double average = sum / arraySize;
		
		System.out.printf("And their average is: %.3f\n", average);		
	}
}