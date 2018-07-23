//File name: Operator.java
//Author: Paul Minniti
//Date: 4 April 2017
/*This programming project involves writing a program that accepts an arithmetic
expression of unsigned integers in postfix notation and builds the arithmetic expression 
tree that represents that expression. From that tree, the corresponding fully parenthesized 
infix expression should be displayed and a file should be generated that contains the
 three address format instructions. 
*/

public class Operator extends Node{
	
	//constructor
	public Operator(char data) {
        this.value=data;
        this.leftValue=null;
        this.rightValue=null;
    }

    //get left value
    public Node getLeft() {
        return leftValue;
    }

    //set left value
    public void setLeft(Node left) {
        this.leftValue = left;
    }

    //get right value
    public Node getRight() {
        return rightValue;
    }

    //set right value
    public void setRight(Node right) {
        this.rightValue = right;
    }
    
   //tostring method override
   @Override
   public String toString()
   {
       return "( "+this.leftValue+" "+value+" "+this.rightValue+" )";
   }
}
