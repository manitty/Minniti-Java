//File name: Operand.java
//Author: Paul Minniti
//Date: 4 April 2017
/*This programming project involves writing a program that accepts an arithmetic
expression of unsigned integers in postfix notation and builds the arithmetic expression 
tree that represents that expression. From that tree, the corresponding fully parenthesized 
infix expression should be displayed and a file should be generated that contains the
 three address format instructions. 
*/

public class Operand extends Node{
	
	//constructor
	public Operand(char data) {	
        this.value=data;
        this.leftValue=null;
        this.rightValue=null;
    }
    
	//tostring method override
	@Override
    public String toString()
    {
        return value+"";
    }
}
