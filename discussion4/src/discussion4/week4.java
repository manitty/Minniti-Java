package discussion4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class week4 extends JFrame implements ActionListener{
	JLabel weight = new JLabel("Weight in Lbs");
	JLabel height = new JLabel("Height in inches");
	JLabel out = new JLabel("Output");
	JTextField weight_input = new JTextField(20);
	JTextField height_input = new JTextField(20);
	JTextField output = new JTextField(20);
	JButton calculate = new JButton("Calculate");
	
	public week4(){
		setTitle("BMI calculator");
		setSize(360,200);
		add(weight);
		add(weight_input);
		add(height);
		add(height_input);
		add(out);
		add(output);
		add(calculate);
		calculate.addActionListener(this);
		output.setEditable(false);
		GridLayout layout = new GridLayout(5,2);
		setLayout(layout);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String Weight = weight_input.getText();
		String Height = height_input.getText();
		double weight_d = Double.parseDouble(Weight);
		double height_d = Double.parseDouble(Height);
		Object calc = ae.getSource();
		if(calculate == calc){
			weight_d = weight_d * 0.45;
			height_d = height_d * 0.025;
			height_d = height_d * height_d;
			weight_d = weight_d / height_d;
			output.setText(String.valueOf(weight_d));
		}
		
	}
	public static void main(String[] args){
		week4 i = new week4();
		i.setVisible(true);
	}
	
}
