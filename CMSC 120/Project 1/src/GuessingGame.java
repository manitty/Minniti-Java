import java.util.Scanner;

//NICK RILEY

public class GuessingGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scanner keyboard = new Scanner (System.in);
	
	int a;
	int b;
	int c;
	int answer;
	int sum;
	
	System.out.println("Welcome to the guessing game.");
	System.out.println("1 - Add two numbers");
	System.out.println("2 - Subtract two numbers");
	System.out.println("3 - Multiply two numbers");
	System.out.println("4 - Divide two numbers");
	System.out.println("0 - End the program");
	System.out.println("Enter your choice:");

	a= keyboard.nextInt();
	
System.out.println ("Enter two numbers: ");
	
	b= keyboard.nextInt();
	c= keyboard.nextInt();
	sum = 0;
	
System.out.println("What would the correct answer be?");
	answer = keyboard.nextInt();
	
	switch (a) {
	case 1 : sum = b + c;
		break;
	case 2 : sum = b - c;
		break;
	case 3 : sum = b * c;
		break;
	case 4 : sum = b / c;
		break;
	case 0 : System.out.println("The program has ended.");
		break;
	
	}
	
	if (a != 0) {
		if (sum == answer) {
		System.out.println ("Your answer is correct!");
			}
	 if (sum != answer) {
		System.out.println ("Answer is not right, the correct answer is: " + sum);
	}
		}
			}
		}
	
	


