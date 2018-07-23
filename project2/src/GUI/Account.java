//File name: Account.java
//Author: Paul Minniti
//Date: 5 February 2017
//This project involves writing a program that implements an ATM machine.
package GUI;

public class Account {
	//instance variables
    private double Checking = 0;
    private double Savings = 0;
    private int Withdrawals = 0;
    private double fee = 1.50;
    
    //method to add value to Checking
    void addChecking(double i){
        this.Checking += i;
    }
    //method to add value to Savings
    void addSavings(double i){
        this.Savings += i;
    }
    //method to subtract value from Checking
    void subtractChecking(double i){
        this.Checking -= i;
    }
    //method to subtract value from Savings
    void subtractSavings(double i){
        this.Savings -= i;
    }
    //returns the value of Checking
    double getChecking(){
        return Checking;
    }
    //returns the value of Savings
    double getSavings(){
        return Savings;
    }
    //increases the withdrawal count
    void IncrementWithdrawalscount(){
    	Withdrawals++;
    }
    //returns the # of withdrawals
    int getWithdrawalsCount(){
        return Withdrawals;
    }
    
    //returns the fee value
    double getFee(){
        return fee;
    }
}
