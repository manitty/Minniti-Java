package discussion4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class week4_1 extends JFrame implements ActionListener{
	JLabel inv = new JLabel("Investment Amount");
	JLabel years = new JLabel("Years");
	JLabel interest = new JLabel("Interest Rate");
	JLabel value = new JLabel("Future Value");
	JTextField inv_input = new JTextField(20);
	JTextField years_input = new JTextField(20);
	JTextField interest_input = new JTextField(20);
	JTextField Future_value = new JTextField(20);
	JButton calculate = new JButton("Calculate");
	
	public week4_1(){
		setTitle("Investment calculator");
		setSize(360,200);
		add(inv);
		add(inv_input);
		add(years);
		add(years_input);
		add(interest);
		add(interest_input);
		add(value);
		add(Future_value);
		add(calculate);
		calculate.addActionListener(this);
		Future_value.setEditable(false);
		GridLayout layout = new GridLayout(5,2);
		setLayout(layout);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
	
		Object calc = ae.getSource();
		if(calculate == calc){
			double ans;
			double investment = Double.parseDouble(inv_input.getText());
			int year = Integer.parseInt(years_input.getText());
			double annual = Double.parseDouble(interest_input.getText());
			double monthly = (annual/12)/100;
			ans = investment * Math.pow((1+monthly), year*12);
			Future_value.setText(String.valueOf(ans));
		}
		
	}
	public static void main(String[] args){
		week4_1 i = new week4_1();
		i.setVisible(true);
	}
	
}