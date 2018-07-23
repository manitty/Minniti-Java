package week1;

public class week1 {

	static int pentagonal(int n)
	{
	int result = 0;
	if(n>0)
	{
	result += 3 * n - 2;
	n--;
	System.out.println(n);
	System.out.println(result);
	pentagonal(n);
	}
	return result;
	}
	
	public static void main(String[] args) {
		System.out.println(pentagonal(5));
    }
	
}
