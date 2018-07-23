package Exceptionpropogation;
import java.util.*;
import java.io.*;
public class Exception {
	
	public static void main(String[] args)
	   {
	       try
	       {
	           System.out.println("Welcome to Java");
	           int i = 0;
	           int y = 2 / i;
	           System.out.println("Welcome to Java");
	       }
	       catch (RuntimeException ex)
	       {
	           System.out.println("Welcome to Java");
	       }
	       finally
	       {
	           System.out.println("End of the block");
	       }
	   }	

}
