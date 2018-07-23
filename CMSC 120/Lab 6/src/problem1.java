import java.util.Scanner;


public class problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		double meters; 
		double menuSelection; 
		double conversion;
		
		System.out.println ("Please enter the number of meters: ");
		meters = keyboard.nextDouble();
			menu (); 
			System.out.println ("enter your choice: ");
			menuSelection = keyboard.nextDouble();
		 	
			while (menuSelection != 4) {
				System.out.println ("enter your choice: ");
				menuSelection = keyboard.nextDouble();
			
				if (menuSelection == 1) {
				conversion = displayKilometers(meters);
			System.out.println("Meters in kilometers is: " + conversion);
			}
			else if (menuSelection == 2) {
				conversion = displayInches (meters);
				System.out.println("Meters in inches is: " + conversion);
			}
			else if (menuSelection == 3) {
				conversion = displayFeet (meters);
				System.out.println ("Meters in feet is: " + conversion);
			}
			}
			if (menuSelection == 4) {
			System.out.println ("The program has ended"); }}
	


	public static void menu () {
	
		System.out.println ("1 - Convert to kilometers");
		System.out.println ("2 - Convert to inches");
		System.out.println ("3 - Convert to feet");
		System.out.println ("4 - End the program");
	}
	
	public static double displayKilometers (double x) {
		double meters;
		meters = 1;
		
		x = meters * 0.001;

		return x; 
	
		}

	public static double displayInches (double x) {
		double meters; 
		meters = 1;
		
		x = meters * 39.37;

		return x; 
	
}
	public static double displayFeet (double x) {
			double meters;
			meters = 1;
			
			x = meters * 3.281;

			return x; 
		
			}
	}






