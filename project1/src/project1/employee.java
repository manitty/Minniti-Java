//File name: employee.java
//Author: Paul Minniti
//Date: 21 January 2017
//This project involves writing a program that computes the salaries for a collection of 
//employees of different types

package project1;

public class employee {
	
	//Variable declaration
	private String employee_name;
	private int employee_salary;

	//A constructor that allows the name and monthly salary to be initialized
	public employee(String employee_name, int employee_salary){
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
	}
	
	//A method named annualSalary that returns the salary for a whole year
	public String annualSalary(){
		int temp;
		temp = employee_salary * 12;
		return String.valueOf(temp);
	}
	
	//A toString method that returns a string containing the name and 
	//monthly salary, appropriately labeled
	public String toString (){
		return"Employee Name: " + employee_name
			 + "\nMonthly Salary: $" + employee_salary
				+"\nAnnual Salary: $"+ annualSalary();
	}
	
	//Setter Methods
	public void set_name(String employee_name){
		this.employee_name = employee_name;
	}
	
	public void set_salary(int employee_salary){
		this.employee_salary = employee_salary;
	}
	
	//Getter Methods
	public String get_name(){
		return employee_name;
	}
	
	public int get_salary(){
		return employee_salary;
	}
}


