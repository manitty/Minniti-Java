//File name: Account.java
//Author: Paul Minniti
//Date: 5 February 2017
//This programming project involves writing a program
//to calculate the terms of the following sequence of numbers: 0 1 2 5 12 29
package Project3;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GUI extends javax.swing.JDialog implements ActionListener{
	//instance variables
    private final JFrame frame;
    private JPanel panel;
    private final JRadioButton recursiveButton;
    private final JRadioButton iterativeButton;
    private final JButton computeButton;
    private final JTextField nTextField;
    private final JTextField resultTextField;
    private final JTextField efficiencyTextField;
    private static Sequence sequence;
  
   //Constructor, creates the Gui
    public GUI(){
     
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Project 3");
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        recursiveButton = new JRadioButton("Recursive");
        iterativeButton = new JRadioButton("Iterative");
        computeButton = new JButton("Compute");
        nTextField = new JTextField();
        resultTextField = new JTextField();
        efficiencyTextField = new JTextField();
        ButtonGroup group = new ButtonGroup();
        group.add(recursiveButton);
        group.add(iterativeButton);
        iterativeButton.setSelected(true);
        iterativeButton.setActionCommand("iterative");
        recursiveButton.setActionCommand("recursive");
        computeButton.setActionCommand("compute");
        iterativeButton.addActionListener(GUI.this);
        recursiveButton.addActionListener(GUI.this);
        computeButton.addActionListener(GUI.this);
        frame.setLayout(new GridLayout(6,2,3,3));
        frame.add(new JLabel(""));
        frame.add(iterativeButton);
        frame.add(new JLabel(""));
        frame.add(recursiveButton);
        frame.add(new JLabel("Enter n:"));
        frame.add(nTextField);
        frame.add(new JLabel(""));
        frame.add(computeButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultTextField);
        frame.add(new JLabel("Efficiency:"));
        frame.add(efficiencyTextField);
        frame.addWindowListener(new WindowAdapterImpl());
        frame.setVisible(true);
    }
  

    //Checks if the input is numeric
    public boolean isNumeric(String str){
            try
            {
               double d = Double.parseDouble(str);
            }
             catch(NumberFormatException nfe)
            {
               JOptionPane.showMessageDialog(frame, "Please Enter a Valid Numerical Value");
               nTextField.setText("");
               return false;
             }
              return true;
        }
 
    // Controls the action performed when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
         String event = e.getActionCommand();
         String text;
         String result;
       
         switch (event){
             case "compute":
                 text = nTextField.getText();
                 if(isNumeric(text) == false) break;
               
                 if(iterativeButton.isSelected()){
                     result = ""+Sequence.calcIterative(Integer.parseInt(text));
                 }
                 else if(recursiveButton.isSelected()){
                     result = ""+Sequence.calcRecursive(Integer.parseInt(text));
                 }
                 else{
                     result = "";
                 }
                 resultTextField.setText(result);
                 efficiencyTextField.setText(""+Sequence.getEfficiency());
                 break;
         }
    }

    //Class that defines a windowAdapter to override windowClosing method 
    //to perform function on window close
    private static class WindowAdapterImpl extends WindowAdapter {

        public WindowAdapterImpl() {
        }
      
        @Override
        public void windowClosing(WindowEvent e){
            try {
                int iterativeE;
                int recursiveE;
                FileWriter fw = new FileWriter("Efficiency Values.csv");
                for(int n = 0; n <= 10; n++){
                    Sequence.calcIterative(n);
                    iterativeE = Sequence.getEfficiency();
                    Sequence.calcRecursive(n);
                    recursiveE = Sequence.getEfficiency();
                    fw.write(n+","+iterativeE+","+recursiveE+"\n");
                }
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
    
  //Main Method
    public static void main(String[] args) {
        GUI i = new GUI();
    }
}
