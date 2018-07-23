import java.util.Scanner;


public class problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner userInput = new Scanner (System.in);
	
	System.out.println("Enter the mass (kilograms): ");
	double m;
	double energy;
	
	m = userInput.nextInt();
	
	energy = energy(m);
	
	System.out.println ("The energy is " + energy);
	
	}

public static double energy(double m) {
	double c;
	double e;
	c = 299792458;
	
	e = m * (c * c);
	
	return e;
	
}}
