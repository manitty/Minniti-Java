import java.util.Scanner;

	// Nick Riley
	// This program will manipulate strings when input is given 

public class Strings {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
	// Show the menu	
		menu();
	
	// Declare the variables
		double choice;
		String stringinput;
		choice = keyboard.nextDouble();
	
	// After user input, the choice is made for which function will be called	
	while (choice != 0) {
		   if (choice == 1) {
				String function;
				System.out.println("please enter a string: ");	
				stringinput = keyboard.next();
				function =	reverseString(stringinput);
					System.out.println("The string reversed is: " + function);
		   											}
			
		   else if (choice == 2) {
				boolean a = false;	
				String stringinput1;
				System.out.println("please enter a string: ");	
				stringinput1 = keyboard.next();	
					a = palindrome(stringinput1);
						if (a == true) {
						System.out.println ("It is a palindrome");
					}
						else  {
						System.out.println("It is not a palindrome");
											}
													}
			
			else if (choice == 3) {
				int function; 
				System.out.println("please enter a string: ");
				stringinput = keyboard.next();
				function = vowels(stringinput);
				System.out.println("There are " + function + " vowels.");
													}
			
			
			else if (choice == 4) {
				System.out.println ("please enter a string: ");
				stringinput = keyboard.next();
				occurences(stringinput);
													}
			
			else if (choice == 5) {
				char function; 
				System.out.println ("please enter a string: ");
				stringinput = keyboard.next();
				function = (char) vowelpos(stringinput);
				System.out.println ("The position of the first vowel is: " + function);
													}
			
			else  
			{System.out.println ("Error.. please try again: ");
				choice = keyboard.nextDouble();
										}
													}
		if (choice == 0) {
			System.out.println("Program has ended.");
										}
													}		
				
			
	// shows menu
	public static void menu () {
		System.out.println ("Menu of string line operations:");
		System.out.println ("1 - Reverse a string");
		System.out.println ("2 - Determine if a string is a palindrome or not");
		System.out.println ("3 - Count the number of vowels in a string");
		System.out.println ("4 - Count the number of occurences of a character in a string");
		System.out.println ("5 - Position of the first vowel in a string");
		System.out.println ("0 - End of program");
	}
	
	// reverses string
public static String reverseString (String s) {
		String string = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			string += (s.charAt(i));
			}
		return string;
										}
	
	// calls reverseString function, checks for equality and returns boolean
public static boolean palindrome (String s) {
		if (reverseString(s) == (s) == true) {
		return true;
			}
		else {
			return false;
								}
										}
	// checks for vowels
public static int vowels(String s) {
		int count;
		count = 0;
		char i;
		i = 0;
		if (s.charAt(i) == 'a'|| s.charAt(i) == 'e'|| s.charAt(i) == 'i'|| s.charAt(i) == 'o'|| 
			s.charAt(i) == 'u'|| s.charAt(i) == 'A'|| s.charAt(i) == 'E'|| s.charAt(i) == 'I'||
			s.charAt(i) == 'O'|| s.charAt(i) == 'U')
			{ ++ count; }
	
	
	return count;
										}
	// checks for occurences of first letter in string
public static void occurences(String s) {
		int count = 0;
		for (int i = 0; i< s.length(); i++)
		{
			char c = 0;
			if (c == s.charAt(i)) { 
				++count;
						}								
								}
		 System.out.println ("The number of occurences of the letter is " + count);
										}

	// uses for loop to check for position of vowel 
public static int vowelpos(String s) {
		for(int i = 0; i<= s.length() - 1;) 
		return i;
		int i = 0;
		return i;
						
								}
										}