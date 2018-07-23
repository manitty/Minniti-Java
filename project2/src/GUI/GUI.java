//File name: GUI.java
//Author: Paul Minniti
//Date: 5 February 2017
//This project involves writing a program that implements an ATM machine.
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame {
	//instance variables
	Account Checking = new Account();
	Account Savings = new Account();
    Account Withdrawal = new Account();
    InsufficientFunds ins = new InsufficientFunds();
    JButton withdraw_button = new JButton("Withdraw");
    JButton deposit_button = new JButton("Deposit");
    JButton transfer_button = new JButton("Transfer to");
    JButton balance_button = new JButton("Balance");
    JRadioButton checking_rb = new JRadioButton("Checking");
    JRadioButton savings_rb = new JRadioButton("Savings");
    JTextField amount = new JTextField(18);

    //constructor
    GUI(){
    	//creates GUI
    	this.setLayout(new FlowLayout(FlowLayout.CENTER));
    	JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(3,2,10,10));
    	panel.add(withdraw_button);
    	panel.add(deposit_button);
    	panel.add(transfer_button);
    	panel.add(balance_button);
    	panel.add(checking_rb);
    	panel.add(savings_rb);
    	ButtonGroup select = new ButtonGroup();
    	select.add(checking_rb);
    	select.add(savings_rb);
    	checking_rb.setSelected(true);
    	this.add(panel,BorderLayout.CENTER);
    	this.add(amount, BorderLayout.SOUTH);
    
    	//method for the Withdraw button
    	withdraw_button.addActionListener(new ActionListener(){
    		//override so we can create our own method
    		@Override
    		public void actionPerformed(ActionEvent ae){
    			try{
    						//Checking if Withdrawal amount is a multiple of 20
    						if(Double.parseDouble(amount.getText()) % 20 == 0){	
       							//Withdraw from Checking
    							if(checking_rb.isSelected()){
    								//checks if 4 withdrawals have been made
    								if(Withdrawal.getWithdrawalsCount() >= 4){
    									//check if sufficient funds are in checking account
    									if(Integer.parseInt(amount.getText()) + Checking.getFee() > Checking.getChecking()){
    										//throws insufficient funds error
        									ins.insufficientFundsSavings();
        								}
    									//if sufficient funds than withdrawal successful and fee is added
        								else{
        									//increment Withdrawal Count
            								Withdrawal.IncrementWithdrawalscount();
        									Component frame = null;
        									JOptionPane.showMessageDialog(frame, "Withdrawals have Exceeded 4.\nA $1.50 fee will be applied to your transaction.\nWithdrawal Successful");
        									Checking.subtractChecking(Integer.parseInt(amount.getText()) + Checking.getFee());
        								}
    									
    							    }
    								//if amount being withdrawn is greater than account balance then
    								//insufficient funds error is thrown
    								else if(Integer.parseInt(amount.getText()) > Checking.getChecking()){
    									ins.insufficientFundsChecking();
    								}
    								//if amount being withdrawn is less than account balance
    								//withdrawal is successful 
    								else{
    									//increment Withdrawal Count
        								Withdrawal.IncrementWithdrawalscount();
    									Checking.subtractChecking(Integer.parseInt(amount.getText()));
    									Component frame = null;
    									JOptionPane.showMessageDialog(frame,"Withdrawal Successful");
    								}
    							}
    							
    							//Withdraw from Savings
    							else if(savings_rb.isSelected()){
    								//checks if 4 withdrawals have been made
    								if(Withdrawal.getWithdrawalsCount() >= 4){
    									//check if sufficient funds are in checking account
    									if(Integer.parseInt(amount.getText()) + Savings.getFee() > Savings.getSavings()){
    										//throws insufficient funds error
        									ins.insufficientFundsSavings();
        								}
    									//if sufficient funds than withdrawal successful and fee is added
        								else{
        									//increment Withdrawal Count
            								Withdrawal.IncrementWithdrawalscount();
        									Component frame = null;
        									JOptionPane.showMessageDialog(frame, "Withdrawals have Exceeded 4.\nA $1.50 fee will be applied to your transaction.\nWithdrawal Successful");
        									Savings.subtractSavings(Integer.parseInt(amount.getText()) + Savings.getFee());
        								}
    									
    							    }
    								//if less than 4 withdrawals and
    								//if amount being withdrawn is greater than account balance then
    								//insufficient funds error is thrown
    								else if(Integer.parseInt(amount.getText()) > Savings.getSavings()){
    									ins.insufficientFundsSavings();
    								}
    								//if amount being withdrawn is less than account balance
    								//withdrawal is successful 
    								else{
    									//increment Withdrawal Count
        								Withdrawal.IncrementWithdrawalscount();
    									Savings.subtractSavings(Integer.parseInt(amount.getText()));
    									Component frame = null;
    									JOptionPane.showMessageDialog(frame,"Withdrawal Successful");
    								}
    							}
    								
    				}
    				 //if user enters a number that is not a multiple of 20		
    				 else{
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "Amount entered is not an increment of $20.\nPlease try again.");
   						}
    			
    		}
    			//if a user enters anything other than a number
    			catch(RuntimeException e){
    				Component frame = null;
    				JOptionPane.showMessageDialog(frame, "Please Enter a Number.");
    				amount.setText("");
    			} 			
    		}
    	});
    	
    	//method for deposit button
    	deposit_button.addActionListener(new ActionListener(){
    		//override so we can create our own method
    		@Override
    		public void actionPerformed(ActionEvent ae){
    			try{
    				//deposits user defined amount into checking account
    				if(checking_rb.isSelected()){
    					Checking.addChecking(Integer.parseInt(amount.getText()));
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "$" + (Integer.parseInt(amount.getText()))+ " Deposite Successful");
    				}
    				//deposits user defined amount into savings account
    				else if(savings_rb.isSelected()){
    					Savings.addSavings(Integer.parseInt(amount.getText()));
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "$" + (Integer.parseInt(amount.getText()))+ " Deposite Successful");
    				}
    			}
    			//if a user enters anything but a number
    			catch(RuntimeException e){
    				Component frame = null;
    				JOptionPane.showMessageDialog(frame, "Please Enter a Number");
    				amount.setText("");
    			}
    		}
    	});
    	
    	//method for balance button
    	balance_button.addActionListener(new ActionListener(){
    		//override so we can create our own method
    		@Override
    		public void actionPerformed(ActionEvent ae){
    				//returns balance of checking account
    				if(checking_rb.isSelected()){
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "$" + Double.toString(Checking.getChecking()) + " Balance in Checking Account");
    				}
    				//returns balance of savings account
    				else if(savings_rb.isSelected()){
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "$" + Double.toString(Savings.getSavings()) + " Balance in Savings Account");
    				}
    		}
    	});
    	
    	//method for transfer button
    	transfer_button.addActionListener(new ActionListener(){
    			//override so we can create our own method
    			@Override
    			public void actionPerformed(ActionEvent ae){
    				try{
    					//transfer from savings to checking
    					if(checking_rb.isSelected()){
    						//checks if sufficient funds in savings
    						if(Double.parseDouble(amount.getText()) > Savings.getSavings()){
    							//throws insufficient funds error
    							ins.insufficientFundsSavingsTransfer();
    						}
    						//if sufficient funds, completes transfer 
    						else{
    							Checking.addChecking(Integer.parseInt(amount.getText()));
    							Savings.subtractSavings(Integer.parseInt(amount.getText()));
    							Component frame = null;
    							JOptionPane.showMessageDialog(frame, "$" + Integer.parseInt(amount.getText()) + " Transfer from Savings account to Checking account Successful.");
    						}
    					}
    					//transfer from checking to savings
    					else if(savings_rb.isSelected()){
    						//checks if sufficient funds in checking
    						if(Double.parseDouble(amount.getText()) > Checking.getChecking()){
    							//throws insufficient funds error
    							ins.insufficientFundsCheckingTransfer();
    						}
    						//if sufficient funds, completes transfer
    						else{
    							Savings.addSavings(Integer.parseInt(amount.getText()));
    							Checking.subtractChecking(Integer.parseInt(amount.getText()));
    							Component frame = null;
    							JOptionPane.showMessageDialog(frame, "$" + Integer.parseInt(amount.getText()) + " Transfer from Checking account to Savings account Successful.");
    						}
    					}
    				}
    				//if a user enters anything but a number
    				catch(RuntimeException e){
    					Component frame = null;
    					JOptionPane.showMessageDialog(frame, "Please Enter a number");
    					amount.setText("");
    				}
    			}
    	});
    	
    	
    }
    //main method
    public static void main(String[] args){
        GUI atm = new GUI();
        atm.setTitle("ATM Machine");
        atm.setSize(360, 200);
        atm.setLocationRelativeTo(null);
        atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm.setVisible(true);

    }
}
