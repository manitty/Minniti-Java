//File name: InsuddicientFunds.java
//Author: Paul Minniti
//Date: 5 February 2017
//This project involves writing a program that implements an ATM machine.
package GUI;
import java.awt.Component;
import javax.swing.JOptionPane;
public class InsufficientFunds {
	
    void insufficientFundsChecking(){
        Component frame = null;
        JOptionPane.showMessageDialog(frame,"Checking Account has Insufficient Funds!");
    }
  
    void insufficientFundsSavings(){
        Component frame = null;
        JOptionPane.showMessageDialog(frame,"Savings Account has Insufficient Funds!");
    }
  
    void insufficientFundsCheckingTransfer(){
        Component frame = null;
        JOptionPane.showMessageDialog(frame,"Checking Account has Insufficient Funds! \n"
                + "Transfer Cannot be Complete.");
    }
      
    void insufficientFundsSavingsTransfer(){
        Component frame = null;
        JOptionPane.showMessageDialog(frame,"Savings Account has Insufficient Funds! \n"
                + "Transfer Cannot be Complete.");
    }
}
