public class Clock{

	private int day, hour, minute, second;
	
	public static void main(String[] args){
		
		System.out.println("Test for clock t1:");
		Clock t1 = new Clock(); // Default constructor
		
		t1.setHour(23);
		t1.setDay(1);
		t1.setMinute(59);
		t1.setSecond(16);
		
		System.out.println("After setting clock time:");
		System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
		
		t1.increment(44);
		System.out.println("Increment by 44 seconds:");
		System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
		
		System.out.printf("The elapsed time in seconds is %d\n", t1.calculateTotalSeconds());
		
		System.out.println("Test for clock t2:");
		Clock t2 = new Clock(3,1,4,5);
		
		System.out.println("Test for constructor:");
		System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
		
		t2.increment(3601);
		System.out.println("Increment by 3601 seconds:");
		System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
		
		t2.setMinute(8);
		System.out.println("Set minute to 8:");
		System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
	}
	
	public Clock(){
		this(0,0,0,0);
	}
	
	public Clock(int day, int hour, int minute, int second){
		this.setDay(day);
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}
	
	public int getDay(){return day;}
	
	public int getHour(){return hour;}
	
	public int getMinute(){return minute;}
	
	public int getSecond(){return second;}

	public void setDay(int day){
		this.day = day;
	}
	
	public void setHour(int hour){
		if (hour >= 0 || hour < 24) 
			this.hour = hour;
		else
			System.out.println("Hour value out of range!");
	}
	
	public void setMinute(int minute){
		if (minute >= 0 || minute < 60) 
			this.minute = minute;
		else
			System.out.println("Minute value out of range!");
	}
	
	public void setSecond(int second){
		if (second >= 0 || second < 60) 
			this.second = second;
		else
			System.out.println("Second value out of range!");
	}
	
	public void increment(int time){
		second += time;

		while(second > 59){
			second -= 60;
			minute++;
		}
		while(minute > 59){
			minute -= 60;
			hour++;
		}
		while(this.hour > 23){
			hour -= 24;
			day++;
		}
	}
	
	public int calculateTotalSeconds(){
		return (3600*24*day + 3600*hour + 60*minute + second);
	}
	
}