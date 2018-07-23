


import java.util.ArrayList;
import java.util.HashMap;


public class Search {
	public static ArrayList<Person> findByName(String searchText, HashMap<Integer, SeaPort> ports) {
		System.out.println("looking for name containing "+searchText+ " in "+ports.size()+" ports");
		ArrayList<Person> people = new ArrayList<Person>();
		
		for (SeaPort port : ports.values()) {
			for (Person person : port.getPerson()) {
				if (person.getName().equalsIgnoreCase(searchText)) {
					System.out.println(String.format("Found a match: %s", person.toString()));
					people.add(person);
				}
			}
		}
		return people;
	}
	
	public static Person findByIndex(String searchText, HashMap<Integer, SeaPort> ports) {
		for (SeaPort port : ports.values()) {
			for (Person person : port.getPerson()) {
				try {
					if (Integer.valueOf(searchText).intValue()==person.getIndex()) {
						System.out.println(String.format("Found a match: %s", person.toString()));
						return person;
					}
				}
				catch (NullPointerException e) {}
			}	
			
		}
		return null;
	}
	
	public static ArrayList<Person> findBySkill(String searchText, HashMap<Integer, SeaPort> ports) {
		System.out.println("Searching people by skill.");
		ArrayList<Person> people = new ArrayList<Person>();
		for (SeaPort port : ports.values()) {
			for (Person person : port.getPerson()) {
				if (person.getSkill().equalsIgnoreCase(searchText)) {
					System.out.println(String.format("Found a match: %s", person.toString()));
					people.add(person);
				}
			}
		}
		return people;
	}

}
