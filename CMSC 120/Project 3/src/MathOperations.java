import java.util.Scanner;


public class MathOperations {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		menu();
		
		int n;
		int b;
		int choice;
		System.out.println("Please input a choice: ");
		choice = keyboard.nextInt();

if (choice == 1) {
	System.out.println("Input a number: ");
	n = keyboard.nextInt();
	factor(n);
}
else if (choice == 2) {
	System.out.println("Input a number: ");
	n = keyboard.nextInt();
	boolean a;
		a = prime(n); 
			if (a == true) {
				System.out.println("Is a prime number");}
				else {
					System.out.println("It is not a prime number");				}
			}

else if (choice == 3) {
	System.out.println("Input a number: ");
	n = keyboard.nextInt();
	b = factorial(n);
		System.out.print(b);
}
else if (choice == 4) {
	System.out.println("Input a number: ");
	n = keyboard.nextInt();
	fib(n);
}
else if (choice == 5) {
	System.out.println("Input 2 numbers: ");
	int num1 = keyboard.nextInt();
	int num2 = keyboard.nextInt();
	boolean a = divisible(num1, num2);
	System.out.println(a);
}
	if (choice == 0 ) {
		System.out.println("End of program");
	}

	}

	public static void menu () {
		System.out.println("Menu of string operations:");
		System.out.println("1-Factors of a number.");
		System.out.println("2-Prime number or not.");
		System.out.println("3-Factorial of a number.");
		System.out.println("4-Fibonacci sequence.");
		System.out.println("5-Number evenly divides another number.");
		System.out.println("0-End ofprogram.");
	}
	public static boolean divisible(int n, int d){
		
		return (n%d==0);
	}
	public static void factor(int n) {
		int i;
		for (i=1; i<=n; ++i) {
			if (n%i==0) {
				System.out.print(i + " ");
			}
		}
	}
	public static boolean prime (int n){
		int divisors =0;
		int i;
		for (i=1; i<=n; ++i) {
			if (n%i==0) {
				divisors++;
			}
		}
		if (divisors == 2){
			return true;
		}
		else{
			return false;
		}
	}
	public static int factorial(int n1){
		int factorial = n1;
		for (int i = 1; i < n1; i ++){
			factorial *= i;
		}
		return factorial;

	}

	public static void fib(int n){
		System.out.print("1 ");

		int one=1;
		int two=1;
		int b=1;
		for(int i= 0; i<= n; ++i){
			b = one + two; 
			one = two;
			two = b;
			System.out.print(b + " ");
		}
	} 		


}



