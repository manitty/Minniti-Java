


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class SortShipsListener implements ActionListener {
	private final World world;
	private final JComboBox<String> dropdown;
	private final String sortType;
	
	public SortShipsListener(World world, JComboBox<String> dropdown, String sortType) {
		this.world = world;
		this.dropdown = dropdown;
		this.sortType = sortType;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (sortType.charAt(0)) {
		case 'l':
			actionPerformedLengthSort(e);
			break;
		case 'd':
			actionPerformedDraftSort(e);
			break;

		case 'w':
			actionPerformedWeightSort(e);
			break;
		case 'X':
			actionPerformedWidthSort(e);
			break;
		case 'n':
			actionPerformedNameSort(e);
			break;
		}
	}

	public void actionPerformedDraftSort(ActionEvent e) {
		int index = new Integer(((String) dropdown.getSelectedItem()).replaceAll("[^0-9]", ""));
		SeaPort port = world.getSeaPortByIndex(index);
		String title = "Ships by draft: " + port.getName();
		ArrayList<Ship> ships = port.getQue();
		
		StringBuffer result = new StringBuffer();
		Collections.sort(ships, new ShipComparator("d"));
		for (Ship s : ships) {
			result.append(String.format("%s - %s\n", s.getName(), s.getDraft()));
		}
		JOptionPane.showMessageDialog(null, result, title, 1);

	}
	
	public void actionPerformedLengthSort(ActionEvent e) {
		int index = new Integer(((String) dropdown.getSelectedItem()).replaceAll("[^0-9]", ""));
		SeaPort port = world.getSeaPortByIndex(index);
		String title = "Ships by length: " + port.getName();
		ArrayList<Ship> ships = port.getQue();
		StringBuffer result = new StringBuffer();

		Collections.sort(ships, new ShipComparator("l"));
		for (Ship s : ships) {
			result.append(String.format("%s - %s\n", s.getName(), s.getLength()));
		}
		world.getSeaPortByIndex(10000).setQueue(ships);
		JOptionPane.showMessageDialog(null, result, title, 1);

	}
	
	public void actionPerformedNameSort(ActionEvent e) {
		int index = new Integer(((String) dropdown.getSelectedItem()).replaceAll("[^0-9]", ""));
		SeaPort port = world.getSeaPortByIndex(index);
		String title = "Ships by name : " + port.getName();
		ArrayList<Ship> ships = port.getQue();

		StringBuffer result = new StringBuffer();

		Collections.sort(ships, new ShipComparator("n"));
		for (Ship s : ships) {
			result.append(String.format("%s\n", s.getName()));
		}
		JOptionPane.showMessageDialog(null, result, title, 1);

	}
	
	public void actionPerformedWeightSort(ActionEvent e) {
		int index = new Integer(((String) dropdown.getSelectedItem()).replaceAll("[^0-9]", ""));
		SeaPort port = world.getSeaPortByIndex(index);
		String title = "Ships by weight: " + port.getName();
		ArrayList<Ship> ships = port.getQue();
		
		StringBuffer result = new StringBuffer();
		Collections.sort(ships, new ShipComparator("w"));
		for (Ship s : ships) {
			result.append(String.format("%s - %s\n", s.getName(), s.getWeight()));
		}
		JOptionPane.showMessageDialog(null, result, title, 1);

	}
	public void actionPerformedWidthSort(ActionEvent e) {
		int index = new Integer(((String) dropdown.getSelectedItem()).replaceAll("[^0-9]", ""));
		SeaPort port = world.getSeaPortByIndex(index);
		String title = "Ships by width: " + port.getName();
		ArrayList<Ship> ships = port.getQue();
		StringBuffer result = new StringBuffer();

		Collections.sort(ships, new ShipComparator("X"));
		for (Ship s : ships) {
			result.append(String.format("%s - %s\n", s.getName(), s.getWidth()));
		}
		JOptionPane.showMessageDialog(null, result, title, 1);

	}
}
	
