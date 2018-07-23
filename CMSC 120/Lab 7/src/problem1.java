import java.util.Scanner;


public class problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner (System.in);
	
		int rolls;
		int n;
		int m = 0;
		
		System.out.println("How many times would you like to roll the dice?");
		rolls = keyboard.nextInt();
	
		n = value (m);
		
		System.out.println ("The value rolled was the same " + n + " times");
	}

	public static int value (int n) {
		double one;
		double two;
		
		one = 1 + (Math.random() * 6);
		two = 1 + (Math.random() * 6);
		if (one == two) {++ n;}
		
		
		return n;
	}
	
	
	
	
}
