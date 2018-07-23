import java.util.Scanner;


public class Problem1 {
	
	// Nick Riley

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner userInput = new Scanner(System.in);
	
	int num;
	System.out.println ("Enter any number 1-7: ");
	num = userInput.nextInt();
	
	switch (num) {
	case 1: System.out.println ("The day is Sunday");
		break;
	case 2: System.out.println ("The day is Monday");
		break;
	case 3: System.out.println ("The day is Tuesday");
		break;
	case 4: System.out.println ("The day is Wednesday");
		break;
	case 5: System.out.println ("The day is Thursday");
		break;
	case 6: System.out.println ("The day is Friday");
		break;
	case 7: System.out.println ("The day is Saturday");
		break;
	 
	}
	
}

}
