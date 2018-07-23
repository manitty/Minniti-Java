/File name: GUI.java
//Author: Paul Minniti
//Date: 4 April 2017
/*This programming project involves writing a program that accepts an arithmetic
expression of unsigned integers in postfix notation and builds the arithmetic expression 
tree that represents that expression. From that tree, the corresponding fully parenthesized 
infix expression should be displayed and a file should be generated that contains the
 three address format instructions. 
*/

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{

	//instance variables
	private JTextField postfixField = new JTextField();
	private JTextField infixField = new JTextField();
	
	//constructor
		GUI(){
			super("Three Address Generator");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			mainScreenFeatures();
			
		}
	
	//Method for GUI
	private void mainScreenFeatures(){
		JLabel postfixLabel = new JLabel("Enter Postfix Expression");
		JLabel infixLabel = new JLabel("Infix Expression");
		JPanel panel1 = new JPanel(new GridBagLayout());
		infixField.setEditable(false);
		panel1.setLayout(new GridLayout(1,2,0,5));
		panel1.add(postfixLabel);
		panel1.add(postfixField);
		add(panel1,BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.add(constructButton());
		add(panel2, BorderLayout.SOUTH);
	
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(infixLabel);
		panel3.add(infixField);
		add(panel3, BorderLayout.CENTER);	
			
		}
	
	//Method for Evaluate button
		private JButton constructButton(){
			final JButton con = new JButton("Construct Tree");
			con.addActionListener(this);
			return con;
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
            String data=postfixField.getText();
            FormatTree t=new FormatTree(data);
            infixField.setText(t.toString());
      } 
      catch (Exception e) 
      {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Please enter Postfix Expression",1);
      }
		
	}
	
	//main method
		public static void main(String[] args){
			GUI main = new GUI();
			main.setVisible(true);
			main.setSize(400,225);
		}
}
