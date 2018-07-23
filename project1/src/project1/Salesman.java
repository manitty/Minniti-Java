//File name: employee.java
//Author: Paul Minniti
//Date: 21 January 2017
//This project involves writing a program that computes the salaries for a collection of 
//employees of different types

package project1;

public class Salesman extends employee {

	//Variable declaration
	private int annual_sales;
	
	//A constructor that allows the name, monthly salary and
	//annual sales to be initialized
	public Salesman(String employee_name, int employee_salary, int annual_sales){
		super(employee_name, employee_salary);
		this.annual_sales = annual_sales;
	}

	//An overridden method annualSalary that returns the salary for a whole year. 
	//The salary for a salesman consists of the base salary computed 
	//from the monthly salary plus a commission. 
	//The commission is computed as 2% of that salesman's 
	//annual sales. The maximum commission a salesman can earn is $20,000
	public String annualSalary(){
		int temp;
		int hold;
		temp = (int) (annual_sales * 0.02);
		
		if(temp > 20000){
			temp = 20000;
		}
		
		hold = get_salary() * 12;
		hold = hold+temp;
		
		return String.valueOf(hold);
	}
	
	//An overridden toString method that returns a string containing 
	//the name, monthly salary and annual sales, appropriately labeled
	public String toString (){
		return "Employee Name: " + get_name()
			 + "\nMonthly Salary: $" + get_salary() +
				"\nAnnual Sales: $" + annual_sales
				+"\nAnnual Salary: $"+ annualSalary();
	}
	
	//Setter Method
	public void set_sales(int annual_sales){
		this.annual_sales = annual_sales;
	}
	
	//Getter Method
	public int get_sales(){
		return annual_sales;
	}
}