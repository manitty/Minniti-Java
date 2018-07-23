import java.util.Scanner;


public class Problem2 {

	// Nick Riley
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner	userInput= new Scanner(System.in);
	System.out.println ("Enter a number: ");

	int n;
	int sum;
	sum = 0;
	
	for (n = userInput.nextInt(); sum < n; n++);
	{
			sum = n + sum; 
		}
	
	System.out.println ("The sum of the numbers is: " + sum);
	
	}

}
