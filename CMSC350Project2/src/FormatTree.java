//File name: FormatTree.java
//Author: Paul Minniti
//Date: 4 April 2017
/*This programming project involves writing a program that accepts an arithmetic
expression of unsigned integers in postfix notation and builds the arithmetic expression 
tree that represents that expression. From that tree, the corresponding fully parenthesized 
infix expression should be displayed and a file should be generated that contains the
 three address format instructions. 
*/

public class FormatTree {
	//instance variables
	Node root;
    boolean added=false;
    
    //constructor
    public FormatTree(String data) throws Exception {
    	//loads expression
       for(int i=data.length()-1;i>=0;i--)
       {
           added=false;
           root=addNode(root, data.charAt(i));
       }
    }
    
    //method to create infix expression
    private Node addNode(Node node,char data) throws Exception
    {
    	//if not empty
        if(node!=null)
        {
        	//if object is an operator character
           if(node instanceof Operator)
           {
        	   //if right is empty or operator
               if(node.rightValue==null||node.rightValue instanceof Operator){
            	   //add node
                   node.rightValue=addNode(node.rightValue, data);
               }
               //if not added and right is empty and Operand
               else if(!added&&node.rightValue!=null&&node.rightValue instanceof Operand)
               {
            	   //if left empty or Operand
                    if(node.leftValue==null||node.leftValue instanceof Operand){
                    	//add node
                        node.leftValue=addNode(node.leftValue, data);
                    }
               }
               //if not added and left is empty or operator
               if(!added&&node.leftValue==null||node.leftValue instanceof Operator){
            	   	  //add node
                      node.leftValue=addNode(node.leftValue, data);
               }
              
           }
         
        }
        //if empty
        else{
            added=true;
            //if true
            if(isOperator(data)){
                //return operator
                return new Operator(data);
            }
            //if false
            else{
            	//return operand
                return new Operand(data);
            }
        }
        return node;
      
    }
    
    //method determines operator type
    private boolean isOperator(char c) throws Exception{
     if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
      return true;
     if(c>='0'&&c<='9')
         return false;
     throw new Exception("Invalid token "+c);
    }
    
    //tostring method override
    @Override
    public String toString(){
        return root.toString();
    }
}
