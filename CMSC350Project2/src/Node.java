//File name: Node.java
//Author: Paul Minniti
//Date: 4 April 2017
/*This programming project involves writing a program that accepts an arithmetic
expression of unsigned integers in postfix notation and builds the arithmetic expression 
tree that represents that expression. From that tree, the corresponding fully parenthesized 
infix expression should be displayed and a file should be generated that contains the
 three address format instructions. 
*/

public abstract class Node {
	
	//instance variables
	char value;
    Node leftValue;
    Node rightValue;

    //get node value
    public char getValue() {
        return value;
    }

    //set node value
    public void setValue(char value) {
        this.value = value;
    }
}
