//File name: employee.java
//Author: Paul Minniti
//Date: 21 January 2017
//This project involves writing a program that computes the salaries for a collection of 
//employees of different types

package project1;

public class executive extends employee {
	
	//Variable declaration
	private int stock_price;
	
	//A constructor that allows the name, monthly salary and stock price to be initialized
	public executive(String employee_name,int employee_salary,int stock_price){
		super(employee_name,employee_salary);
		this.stock_price = stock_price;
	}
	
	//An overridden method annualSalary that returns the salary 
	//for a whole year. The salary for an executive consists of 
	//the base salary computed from the monthly salary plus a bonus. The 
	//bonus is $30,000 if the current stock price is greater than
	//$50 and nothing otherwise
	public String annualSalary(){
		int temp;
		if(stock_price > 50){
			temp = get_salary() * 12;
			temp = temp + 30000;
			return String.valueOf(temp);
			
		}
		else{
			temp = get_salary() * 12;
			return String.valueOf(temp);
			
		}
	}
	
	//An overridden toString method that returns a string 
	//containing the name, monthly salary and stock price, 
	//appropriately labeled
	public String toString (){
		return "Employee Name: " + 	get_name()
				+ "\nMonthly Salary: $" + get_salary() +
				"\nStock Price: $" + stock_price+
				"\nAnnual Salary: $"+ annualSalary();
	}
	
	//Setter Method
	public void set_stock(int stock_price){
		this.stock_price = stock_price;
	}
	
	//Getter Method
	public int get_stock(){
		return stock_price;
	}
}
