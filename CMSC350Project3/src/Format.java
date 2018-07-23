//File name: Format.java
//Author: Paul Minniti
//Date: 23 April 2017
/*This programming project involves writing a program that performs a sort by using a
 *  binary search tree. The program should be able to sort lists of integers or lists 
 *  of fractions in either ascending or descending order. One set of radio buttons should
 *   be used to determine whether the lists contain integers or fractions and a second set 
 *   should be used to specify the sort order.
*/

public class Format extends NumberFormatException {

	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Format() {
		message ="Non numeric input";
	}
}
