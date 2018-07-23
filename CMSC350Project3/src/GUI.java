//File name: GUI.java
//Author: Paul Minniti
//Date: 23 April 2017
/*This programming project involves writing a program that performs a sort by using a
 *  binary search tree. The program should be able to sort lists of integers or lists 
 *  of fractions in either ascending or descending order. One set of radio buttons should
 *   be used to determine whether the lists contain integers or fractions and a second set 
 *   should be used to specify the sort order.
*/
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class GUI implements ActionListener {

	private JFrame frmBinarySearchTree;
	private JTextField orgTxtField;
	private JTextField SortedtxtField;
	private ButtonGroup sortType = new ButtonGroup();
	private ButtonGroup numericType = new ButtonGroup();
	JRadioButton rdbtnInteger = new JRadioButton("Integer");

	JRadioButton rdbtnFraction = new JRadioButton("Fraction");
	JRadioButton rdbtnAscending = new JRadioButton("Ascending");

	JRadioButton rdbtnDescending = new JRadioButton("Descending");

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmBinarySearchTree.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application.
	public GUI() {
		initialize();
	}

	//Initialize the contents of the frame.
	private void initialize() {
		frmBinarySearchTree = new JFrame();
		frmBinarySearchTree.setTitle("Binary Search Tree Sort");
		frmBinarySearchTree.setBounds(100, 100, 446, 308);
		frmBinarySearchTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmBinarySearchTree.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE));

		JLabel lblNewLabel = new JLabel("Original List");

		orgTxtField = new JTextField();
		orgTxtField.setColumns(10);

		JLabel lblSortedList = new JLabel("Sorted List");

		SortedtxtField = new JTextField();
		SortedtxtField.setColumns(10);

		JButton btnPerformSort = new JButton("Perform Sort");
		btnPerformSort.addActionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Sort Order", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Numeric type",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		numericType.add(rdbtnInteger);
		numericType.add(rdbtnFraction);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnInteger)
						.addComponent(rdbtnFraction))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addComponent(rdbtnInteger)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnFraction)
					.addContainerGap(8, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblSortedList))
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(SortedtxtField)
								.addComponent(orgTxtField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(166)
							.addComponent(btnPerformSort))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(orgTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSortedList)
						.addComponent(SortedtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnPerformSort)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE))
					.addGap(19))
		);

		sortType.add(rdbtnAscending);
		sortType.add(rdbtnDescending);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnAscending)
						.addComponent(rdbtnDescending))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(rdbtnAscending)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDescending)
					.addContainerGap(8, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		frmBinarySearchTree.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String data = orgTxtField.getText();
		SortedtxtField.setText("");
		Sort<?> tree ;
		if ("".equals(data)) {
			JOptionPane.showMessageDialog(null, "Enter the data to sort");
			return;
		}
		if (!rdbtnAscending.isSelected() && !rdbtnDescending.isSelected()) {
			JOptionPane.showMessageDialog(null, "Select the sorting option");
			return;
		}
		if (!rdbtnFraction.isSelected() && !rdbtnInteger.isSelected()) {
			JOptionPane.showMessageDialog(null, "Select the data type of data");
			return;
		}
		if (rdbtnFraction.isSelected()) {
			tree= new Sort<Fraction>();
		} else {
			tree = new Sort<Integer>();
		}
		String values[] = data.split(" ");
		try {
			if (rdbtnInteger.isSelected()) {
				Integer a[] = new Integer[values.length];
				for (int i = 0; i < values.length; i++) {
					a[i] = Integer.valueOf(values[i]);
				}
				Sort<Integer> root = ((Sort<Integer>)tree).convertArrBst(a, a.length);
				tree.text="";
				if (rdbtnAscending.isSelected()){
					tree.ascending(root);
				}
				else{
					tree.descending(root);
				}
				SortedtxtField.setText(tree.text);
			}
			else{

				Fraction a[] = new Fraction[values.length];
				for (int i = 0; i < values.length; i++) {
					if(values[i].split("/").length > 2){
						throw new Format();
					}
					if(!values[i].contains("/")){
						Integer.parseInt(values[i]);
						values[i] = values[i]+"/1";
					}
                    Fraction f = new Fraction(values[i]);
                    a[i] =f;
				}
				Sort<Fraction> root = ((Sort<Fraction>)tree).convertArrBst(a, a.length);
				tree.text="";
				if (rdbtnAscending.isSelected()){
					tree.ascending(root);
				}
				else{
					tree.descending(root);
				}
				SortedtxtField.setText(tree.text);
			
			}
		} catch (Format ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			return;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Non numeric input");
			return;
		}

	}
}
