
public class Marathon{
	public static void main(String[] args){
		String[] names = {"Elena", "Thomas", "Hamilton", "Suzie",
		"Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily",
		"Daniel", "Neda", "Aaron", "Kate"};
		
		int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 
		393, 299, 343, 317, 265};
		
		Marathon item = new Marathon();
		int index = item.theFastest(times);
		System.out.printf("The fastest runner is %s and the time is %d.\n", names[index], times[index]);
	}
	
	public int theFastest(int[] timeArray){
		int fastest = timeArray[0];
		int fastestIndex = 0;
		for(int i = 1; i < timeArray.length - 1; i++){
			if(timeArray[i] < fastest){
				fastest = timeArray[i];
				fastestIndex = i;
			}
		}
		return fastestIndex;
	}
}