package week7;


public class Demo {
	public static void main(String[] args) {
		recurse(6);
   }
	

	public static int recurse(int n)
	{
	   if (n <= 1)
	       return 1;
	   else
	       return n + recurse(n - 2);
	}
}
	
