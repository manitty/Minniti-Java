

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;


public class SeaPortsProgram extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel jobPanel = new JPanel();

	private ButtonGroup radioButtonGroup = new ButtonGroup();
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	private JButton searchButton = new JButton("Search");
	private JScrollPane jScrollPane1 = new JScrollPane();
	private JScrollPane jScrollPane1Jobs = new JScrollPane(jobPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JScrollPane jScrollPane1forTree = new JScrollPane();
	
	private JTextArea output = new JTextArea();
	private JTextField searchText = new JTextField(20);
	
	private JRadioButton indexRadioButton = new JRadioButton("Index");
	private JRadioButton nameRadioButton = new JRadioButton("Name");
	private JRadioButton skillRadioButton = new JRadioButton("Skill");
	
	private JComboBox<String> seaportDropdown = new JComboBox<String>();
	
	private JButton sortByNameButton = new JButton("Sort by Name");
	private JButton sortByWeightButton = new JButton("Sort by Weight");
	private JButton sortByWidthButton = new JButton("Sort by Width");
	private JButton sortByDraftButton = new JButton("Sort by Draft");
	private JButton sortByLengthButton = new JButton("Sort by Length");

	
	private JTree tree;
	private World world;
	
	public SeaPortsProgram() {
		JFileChooser jf = new JFileChooser(".");
		jf.showOpenDialog(null);
		jf.setVisible(true);
		File file = jf.getSelectedFile();
		if (file != null) {
			this.setWorld(FileImporter.readFile(file, jobPanel));
			this.guiComponents();
			
			output.setText(world.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Error: You didn't choose a file.", "Error", 1);
		}

	}


	private void guiComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 800));
		output.setColumns(20);
		output.setRows(5);
		jScrollPane1.setViewportView(output);
		jScrollPane1Jobs.setViewportView(jobPanel);

		searchButton.addActionListener(new SearchResultsListener(this.searchText, this.nameRadioButton, this.indexRadioButton, this.skillRadioButton, this.getWorld()));
		sortByWeightButton.addActionListener(new SortShipsListener(world, seaportDropdown, "w"));
		sortByNameButton.addActionListener(new SortShipsListener(world, seaportDropdown, "n"));
		sortByWidthButton.addActionListener(new SortShipsListener(world, seaportDropdown, "X"));
		sortByLengthButton.addActionListener(new SortShipsListener(world, seaportDropdown, "l"));
		sortByDraftButton.addActionListener(new SortShipsListener(world, seaportDropdown, "d"));
		
		radioButtonGroup.add(nameRadioButton);
		nameRadioButton.setActionCommand("name");
		nameRadioButton.setSelected(true);
		
		radioButtonGroup.add(indexRadioButton);
		indexRadioButton.setActionCommand("index");

		radioButtonGroup.add(skillRadioButton);
		skillRadioButton.setActionCommand("skill");
				

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
		for (SeaPort port : world.getPorts().values()) {
			DefaultMutableTreeNode portNode = new DefaultMutableTreeNode(port.getName());
			DefaultMutableTreeNode personNode = new DefaultMutableTreeNode("People");
			DefaultMutableTreeNode shipNode = new DefaultMutableTreeNode("Ships");
			DefaultMutableTreeNode queNode = new DefaultMutableTreeNode("Que");
			DefaultMutableTreeNode dockNode = new DefaultMutableTreeNode("Docks");
			
			for (Person person : port.getPerson()) {
				DefaultMutableTreeNode temp = new DefaultMutableTreeNode(String.format("%d %s %s", person.getIndex(), person.getName(), person.getSkill()));	
				personNode.add(temp);
			}
			for (Ship ship : port.getShips()) {
				DefaultMutableTreeNode temp = new DefaultMutableTreeNode(String.format("%d %s", ship.getIndex(), ship.getName()));	
				shipNode.add(temp);
			}
			for (Ship ship : port.getQue()) {
				DefaultMutableTreeNode temp = new DefaultMutableTreeNode(String.format("%d %s", ship.getIndex(), ship.getName()));	
				queNode.add(temp);
			}
			
			for (Dock dock : port.getDocks()) {
				DefaultMutableTreeNode temp = new DefaultMutableTreeNode(String.format("%d %s: %s", dock.getIndex(), dock.getName(), dock.getShip().getName()));	
				dockNode.add(temp);
			}
			
			portNode.add(personNode);
			portNode.add(dockNode);
			portNode.add(shipNode);
			portNode.add(queNode);
			root.add(portNode);
		}
		this.tree = new JTree(root);
		jScrollPane1forTree.setViewportView(tree);
		for (int i = 0; i < tree.getRowCount(); i++) {
		    tree.expandRow(i);
		}
		

		JPanel searchPanel = new JPanel(new FlowLayout());
		searchPanel.add(searchText);
		searchPanel.add(nameRadioButton);
		searchPanel.add(indexRadioButton);
		searchPanel.add(skillRadioButton);
		searchPanel.add(searchButton);
		
		
		JPanel buttonPanel = new JPanel();
		TitledBorder border = new TitledBorder("Sort ships within queue for a Sea Port");
		border.setTitlePosition(TitledBorder.TOP);
		buttonPanel.setBorder(border);
		
		for (SeaPort sp : this.getWorld().getPorts().values()) {
			seaportDropdown.addItem(sp.getIndex() + ": " + sp.getName());
		}
		
		buttonPanel.add(seaportDropdown);
		buttonPanel.add(sortByDraftButton);
		buttonPanel.add(sortByLengthButton);
		buttonPanel.add(sortByNameButton);
		buttonPanel.add(sortByWeightButton);
		buttonPanel.add(sortByWidthButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		
		BoxLayout jobPanelLayout = new BoxLayout(jobPanel, BoxLayout.Y_AXIS);
		
		jobPanel.setLayout(jobPanelLayout);
		
		jobPanel.setLayout(jobPanelLayout);
		
		tabbedPane.addTab("Jobs", jScrollPane1Jobs);
		tabbedPane.addTab("World", jScrollPane1forTree);
		tabbedPane.addTab("Sort", buttonPanel);
		tabbedPane.addTab("Search", searchPanel);
		
		
		this.add(tabbedPane);
		this.setTitle("Seaport Project 3");
		this.pack();
		this.setVisible(true);
		
	}

	public World getWorld() {
		return this.world;
	}
	
	public void setWorld (World world) {
		this.world = world;
	}

	public static void main(String[] args) {
		new SeaPortsProgram();
	}
}
