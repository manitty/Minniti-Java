


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SearchResultsListener implements ActionListener {
	private JTextField searchText;
	private JRadioButton name, index, skill;
	private World world;

	public SearchResultsListener (JTextField searchText, JRadioButton name, JRadioButton index, JRadioButton skill, World world) {
		this.searchText = searchText;
		this.name=name;
		this.index=index;
		this.skill=skill;
		this.world=world;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Searching by "+searchText.getText());
		
		if (name.isSelected()) {
			String title;
			ArrayList<Person> people = Search.findByName(searchText.getText(), world.getPorts());
			StringBuffer result = new StringBuffer();
			for (Person p : people) {
				result.append(p.toString()).append("\n");
			}
			if (people.isEmpty()) {
				title = "No results found, please try again";
			}
			else {
				title = people.size() + " results found";
			}
			JOptionPane.showMessageDialog(null, result, title, 1);
		}
		
		if (index.isSelected()) {
			String title;
			Person person = Search.findByIndex(searchText.getText(), world.getPorts());
			
			if (person==null) {
				title = "No results found, please try again";
			}
			else {
				title = "One record found";
			}
			
			JOptionPane.showMessageDialog(null, person, title, 1);
			
		}
		
		if (skill.isSelected()) {
			String title;
			ArrayList<Person> people = Search.findBySkill(searchText.getText(), world.getPorts());
			StringBuffer result = new StringBuffer();
			for (Person p : people) {
				result.append(p.toString()).append("\n");
			}
			if (people.isEmpty()) {
				title = "No results found, please try again";
			}
			else {
				title = people.size() + " results found";
			}
			JOptionPane.showMessageDialog(null, result, title, 1);
		}

	}
}
