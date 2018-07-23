import java.util.Scanner;


public class problem2 {

	/**
	 * @param radius2
	 */
	public static void main(String [] args) {
		// TODO Auto-generated method stub
	
	Scanner userInput = new Scanner (System.in);
	
	int radius;
	System.out.println ("Enter the radius: ");
	radius = userInput.nextInt();
	
	
	circleArea (radius);
	}

	
	
	public static void circleArea (double radius)	{
		
		
		 radius = Math.PI * (radius * radius);
		 
		 System.out.println ("The radius is: ");			
		 System.out.printf( "%3.2f", radius );
		
		
		
}
	}