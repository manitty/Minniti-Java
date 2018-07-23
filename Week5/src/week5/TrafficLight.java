package week5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLight extends JFrame{

	private LightActions light = new LightActions();
	private JRadioButton red;
	private JRadioButton yellow;
	private JRadioButton green;
	
	public TrafficLight(){
		JPanel panel = new JPanel();
		light.setLayout(new GridLayout(1, 1));
		panel.add(red = new JRadioButton("Red"));
		panel.add(yellow = new JRadioButton("Yellow"));
		panel.add(green = new JRadioButton("Green"));
		add(panel, BorderLayout.NORTH);
		ButtonGroup button = new ButtonGroup();
		button.add(green);
		button.add(yellow);
		button.add(red);
		add(light, BorderLayout.CENTER);
		
			green.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        light.setState(4);
		      }
		    });
			red.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        light.setState(2);
		      }
		    });

		    yellow.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        light.setState(3);
		      }
		    });

		    green.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        light.setState(4);
		      }
		    });
	}
	public static void main(String[] args){
		TrafficLight frame = new TrafficLight();
	    frame.setTitle("Traffic Light");
	    frame.setSize(250, 350);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
