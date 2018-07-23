package week6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class week6p1 extends JFrame implements ActionListener{
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
	
	public week6p1() {
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
			int iter = Integer.parseInt(in.getText());
			double ival = calc_iterative(iter);
			out.setText(Double.toString(ival));
		}else if(recursive.isSelected()){
			int recur = Integer.parseInt(in.getText());
			double rval = calc_recursive(recur);
			out.setText(Double.toString(rval));
		}
	}
	public static double calc_recursive(int i) {
		if (i == 1){
			return 1.0;
		}else{
			return calc_recursive(i-1) + i;
		}
	}
	public static double calc_iterative(int n){
		double sum = 0.0;
		for(int i = 1; i <= n; i++){
			sum = sum * i;
		}
		return sum;
	}
	public void display() {
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);            
	
	}
	public static void main(String[] args){  
		week6p1 i = new week6p1();
		i.display();
		  
	}
}