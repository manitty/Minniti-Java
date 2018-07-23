//File name: Infix.java
//Author: Paul Minniti
//Date: 26 March 2017
//This programming project involves writing a program that evaluates infix expressions 
//of unsigned integers using two stacks.

import java.util.EmptyStackException;
import java.util.Stack;


public class Infix {

	//instance variables
	Stack<String> numbersStk;
	Stack<Character> operatorsStk;
	
	//constructor
	Infix(){
		numbersStk = new Stack<String>();
		operatorsStk = new Stack<Character>();
	}
	
	public int evaluate(String exp) throws ArithmeticException{
		boolean fail = false;
		try{
			//tokenize the string containing the expression
			String tokens[]=exp.split("");
			//loop through the tokens
			for(int i = 0; i < tokens.length; i++){
				//if it is not an operator operand 
				if(!tokens[i].equals("+")&&
						!tokens[i].equals("*")&&
						!tokens[i].equals("-")&&
						!tokens[i].equals("/")&&
						!tokens[i].equals("(")&&
						!tokens[i].equals(")")){
					//push it onto the operand stack
					numbersStk.push(tokens[i]);
				}
				
				//else if it is a left parenthesis
				else if(tokens[i].equals("(")){
					//push it onto the operator stack
					operatorsStk.push((Character)tokens[i].charAt(0));
				}
				
				//else if it is a right parenthesis
				else if(tokens[i].equals(")")){
					//while top of the operator stack not a left parenthesis
					while(operatorsStk.peek()!='('){
						//pop two operands and an operator
						int x=Integer.parseInt(numbersStk.pop());
						int y=Integer.parseInt(numbersStk.pop());
						char opr = operatorsStk.pop();
						
						//perform operation
						int result=0;
						if(opr == '+'){
							result = y+x;
							//push result onto the operand stack
							numbersStk.push(result+"");
						}
						else if(opr=='-'){
							result = y-x;
							//push result onto the operand stack
							numbersStk.push(result+"");
						}
						else if(opr=='*'){
							result = y*x;
							//push result onto the operand stack
							numbersStk.push(result+"");
						}
						else if(opr=='/'){
							result = y/x;
							//push result onto the operand stack
							numbersStk.push(result+"");
						}
					}
					operatorsStk.pop();
				}
				//else if it is an operator
				else if(tokens[i].equals("+")
						||tokens[i].equals("-")
						||tokens[i].equals("*")
						||tokens[i].equals("/")){
			//while the operator stack is not empty and has highest precedence
			while(!operatorsStk.empty()
					&&hasHigherPrecedence(operatorsStk.peek(),tokens[i].charAt(0))){
				//pop two operands and an operator
				int x=Integer.parseInt(numbersStk.pop());
				int y=Integer.parseInt(numbersStk.pop());
				char opr = operatorsStk.pop();
				
				//perform operation
				int result=0;
				if(opr == '+'){
					result = y+x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='-'){
					result = y-x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='*'){
					result = y*x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='/'){
					result = y/x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
			}
			//push the current operator on the operators stack
			operatorsStk.push(tokens[i].charAt(0));
		}
	}
			//while the operator stack is not empty
			while(!operatorsStk.empty()){
				//pop two operands and an operator
				int x=Integer.parseInt(numbersStk.pop());
				int y=Integer.parseInt(numbersStk.pop());
				char opr = operatorsStk.pop();
				
				//perform operation
				int result=0;
				if(opr == '+'){
					result = y+x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='-'){
					result = y-x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='*'){
					result = y*x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
				else if(opr=='/'){
					result = y/x;
					//push result onto the operand stack
					numbersStk.push(result+"");
				}
			}
		}
		catch(EmptyStackException e){
			fail=true;
		}
		if(fail==false){
			//the final result is at the top of the operand stack
			return Integer.parseInt(numbersStk.pop());
		}
		else{
			return -1;
		}
	}

	//method for highest precedence
	boolean hasHigherPrecedence(char top, char current) {
		int topPre=-1;
		int curPre=-1;
		if(top=='-'){
			topPre=1;
		}
		if(top=='+'){
			topPre=2;
		}
		if(top=='/'){
			topPre=3;
		}
		if(top=='*'){
			topPre=4;
		}
		if(current=='-'){
			curPre=1;
		}
		if(current=='+'){
			curPre=2;
		}
		if(current=='/'){
			curPre=3;
		}
		if(current=='*'){
			curPre=4;
		}
		if(topPre>=curPre){
			return true;
		}
		else{
			return false;
		}
	}
}
	

