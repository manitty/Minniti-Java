
import java.util.ArrayList;
import java.util.Scanner;


public class SeaPort extends Thing {
	
	private ArrayList<Dock> docks;
	private ArrayList<Ship> ships;
	private ArrayList<Ship> queue;
	private ArrayList<Person> person;

	public SeaPort(Scanner scannerInput) {
		super(scannerInput);
		docks = new ArrayList<>();
		ships = new ArrayList<>();
		queue = new ArrayList<>();
		person = new ArrayList<>();
	}


	public ArrayList<Dock> getDocks() {
		return docks;
	}


	public void setDocks(ArrayList<Dock> docks) {
		this.docks = docks;
	}


	public ArrayList<Ship> getQue() {
		return queue;
	}


	public void setQueue(ArrayList<Ship> que) {
		this.queue = que;
	}


	public ArrayList<Ship> getShips() {
		return ships;
	}


	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}


	public ArrayList<Person> getPerson() {
		return person;
	}


	public void setPerson(ArrayList<Person> person) {
		this.person = person;
	} 
	public String toString() {
		String st = "\n\nSeaPort: " + super.toString();
		for (Dock md : docks)
			st += "\n" + md;
		st += "\n\n --- List of all ships in que:";
		for (Ship ms : queue)
			st += "\n   > " + ms;
		st += "\n\n --- List of all ships:";
		for (Ship ms : ships)
			st += "\n   > " + ms;
		st += "\n\n --- List of all persons:";
		for (Person mp : person)
			st += "\n   > " + mp;
		return st;
	}
}
