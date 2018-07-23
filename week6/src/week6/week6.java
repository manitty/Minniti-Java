package week6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class week6 extends JFrame implements ActionListener{
	private JFrame jFrame;
	private JPanel center;
	private JPanel left;
	private JPanel right;
	private JLabel enter;
	private JLabel result;
	private JRadioButton iterative;
	private JRadioButton recursive;
	private JTextField in;
	private JTextField out;
	private JButton calculate;
	private ButtonGroup buttons;
	
	public week6() {
		jFrame = new JFrame(" ");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enter = new JLabel("Enter i: ");
		result = new JLabel("Result: ");
		calculate = new JButton("Compute");
		calculate.addActionListener(this);
		in = new JTextField(20);
		out = new JTextField(20);
		out.setEditable(false);
		iterative = new JRadioButton("Iterative");
		recursive = new JRadioButton("Recursive", true);
		buttons = new ButtonGroup();
		buttons.add(iterative);
		buttons.add(recursive);
		center = new JPanel();
		center.setLayout(new BorderLayout());
		left = new JPanel();
		left.setLayout(new GridLayout(5,1));
		left.add(new JLabel(""));
		left.add(new JLabel(""));
		left.add(enter);
		left.add(new JLabel(""));
		left.add(result);
		center.add(BorderLayout.WEST, left);
		right = new JPanel();
		right.setLayout(new GridLayout(5,1));
		right.add(iterative);
		right.add(recursive);
		right.add(in);
		right.add(calculate);
		right.add(out);
		center.add(BorderLayout.EAST, right);
		jFrame.getContentPane().add(center);
	}
	public void actionPerformed(ActionEvent event) {    
		if(iterative.isSelected()){
			int ite = Integer.parseInt(in.getText());
			double iteVal = calc_iterative(ite);
			out.setText(Double.toString(iteVal));
		}else if(recursive.isSelected()){
			int rec = Integer.parseInt(in.getText());
			double recVal = calc_recursive(rec);
			out.setText(Double.toString(recVal));
		}
	}
	public static double calc_recursive(int i) {
		if (i == 1){
			return 1.0/3.0;
		}else{
			double sum1 = ((double)i/(2*(double)i +1));
			return calc_recursive(i-1) + sum1;
		}
	}
	public static double calc_iterative(int n){
		double sum = 0.0;
		for(int i = 1; i <= n; i++){
			sum = sum + ((double)i / (2*(double)i + 1));
		}
		return sum;
	}
	public void display() {
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);            
	
	}
	public static void main(String[] args){  
		week6 i = new week6();
		i.display();
		  
	}
}
