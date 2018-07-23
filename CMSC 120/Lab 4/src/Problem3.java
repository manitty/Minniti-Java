import java.util.Scanner;


public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner userInput = new Scanner(System.in);
		
		
		
		int rows;
		int columns;
		int i;
		int j;
		
		System.out.println("Enter a number of rows:");
		rows= userInput.nextInt();
		System.out.println("Enter a number of columns:");
		columns = userInput.nextInt();


		for (i = 0; i < rows; ++ i);{
				for (j = 0; j < columns; ++ j);{
					System.out.println ("*");
				} System.out.println();
		}
		
	}


}
