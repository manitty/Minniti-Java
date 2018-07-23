import java.util.Scanner;


public class Weekday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Scanner userInput = new Scanner(System.in);
	//Nick Riley

	//Declare variables
	int num; 

	System.out.print("enter a number: ");
	num=userInput.nextInt();

	if (num == 1 )
	{
	System.out.println ("Day is Sunday");
		}
	else if (num == 2)
	{System.out.println ("Day is Monday");}
	
	else if (num == 3)
	{System.out.println ("Day is Tuesday");}
	
	else if (num == 4)
	{System.out.println ("Day is Wednesday");}
	
	else if (num == 5)
	{System.out.println ("Day is Thursday");}
	
	else if (num == 6)
	{System.out.println ("Day is Friday");}
	
	else if (num == 7)
	{System.out.println ("Day is Saturday");}
	
	}
	

} 