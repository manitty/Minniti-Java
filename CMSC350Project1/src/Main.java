//File name: Main.java
//Author: Paul Minniti
//Date: 26 March 2017
//This programming project involves writing a program that evaluates infix expressions 
//of unsigned integers using two stacks.
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

public class Main extends JFrame implements ActionListener{

	//instance variables
	private JTextField infixField = new JTextField();
	private JTextField resultField = new JTextField();

	
	
	//constructor
	Main(){
		super("Infix Expression Evaluator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainScreenFeatures();
		
	}
	
	//Method for GUI
	private void mainScreenFeatures(){
		JLabel infixLabel = new JLabel("Enter Infix Expression");
		JLabel resultLabel = new JLabel("Result");
		JPanel panel1 = new JPanel(new GridBagLayout());
		resultField.setEditable(false);
		panel1.setLayout(new GridLayout(1,2,0,5));
		panel1.add(infixLabel);
		panel1.add(infixField);
		add(panel1,BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.add(evalButton());
		add(panel2, BorderLayout.CENTER);
	
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(resultLabel);
		panel3.add(resultField);
		add(panel3, BorderLayout.SOUTH);	
		
	}
	
	//Method for Evaluate button
	private JButton evalButton(){
		final JButton eval = new JButton("Evaluate");
		eval.addActionListener(this);
		return eval;
	}
	
	//Action method
	@Override
	public void actionPerformed(ActionEvent e) {
		Infix infix = new Infix();
		String expression=infixField.getText();
			try{
				int result = infix.evaluate(expression);
				if(result==-1){
					resultField.setText("Expression Error");
				}
				else{
					resultField.setText(""+result);
				}
			}
			catch(ArithmeticException ae){
				JOptionPane.showMessageDialog(this, "Divid by zero error.");
			}
		}
		
	
	//main method
	public static void main(String[] args){
		Main main = new Main();
		main.setVisible(true);
		main.setSize(400,225);
	}
	
}
