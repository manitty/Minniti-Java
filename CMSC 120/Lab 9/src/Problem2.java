import java.util.Scanner;


public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner keyboard = new Scanner (System.in);
	int a;
	int b;
	int i;
	int c = 0;
	int sum = 0;
	int d;
	int average;
		System.out.println ("Please input the number of students: ");
			a = keyboard.nextInt();
		System.out.println ("Please input the number of grades: ");
			b = keyboard.nextInt();
	for (d=1; d <=a; ++d) {
			for (i=1; i <= b; ++i) {
		System.out.println("Input grade " + i );
			c = keyboard.nextInt();
		    sum = c + c; }
			average = (int) average(sum, c);
			System.out.println("Student " + d + " average is:" + average);
		 
		}
	 
	}
	
	public static double average(double a, double b) {
		double average;
		average = a % b;
		return average;
		
	}
	}

