//File name: Fraction.java
//Author: Paul Minniti
//Date: 23 April 2017
/*This programming project involves writing a program that performs a sort by using a
 *  binary search tree. The program should be able to sort lists of integers or lists 
 *  of fractions in either ascending or descending order. One set of radio buttons should
 *   be used to determine whether the lists contain integers or fractions and a second set 
 *   should be used to specify the sort order.
*/

public class Fraction implements Comparable {

	String value;
	 Fraction(String s){
		value = s; 
	 }
	 
	 @Override
	public String toString() {
		return value;
	}

	@Override
	public int compareTo(Object o) {
		String s =o.toString();
		String values[] =s.split("/");
		
		Float f = Float.valueOf(values[0])/Float.valueOf(values[1]);
		values =value.split("/");
		Float result =Float.valueOf(values[0])/Float.valueOf(values[1]);
		return f.compareTo(result);
		
	}
}