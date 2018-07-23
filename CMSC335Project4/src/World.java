


import java.util.HashMap;
import java.util.Scanner;


public class World extends Thing {

	private HashMap<Integer, SeaPort> ports;
	private PortTime time;

	public World(Scanner scannerInput) {
		super(scannerInput);
		ports = new HashMap<Integer, SeaPort>();
	}

	public Ship getShipByIndex(int x) {
		for (SeaPort msp : ports.values())
			for (Ship ms : msp.getShips())
				if (ms.index == x)
					return ms;
		return null;
	}

	public Dock getDockByIndex(int x) {
		for (SeaPort msp : this.getPorts().values())
			for (Dock ms : msp.getDocks())
				if (ms.index == x)
					return ms;
		return null;
	}

	public SeaPort getSeaPortByIndex(int x) {
		SeaPort port = this.ports.get(x);
		if (port!=null) {
			return port;
		}
		return null;
	}

	public void assignShip(Ship ship) {
		Dock dock = getDockByIndex(ship.parent);
		if (dock == null) {
			SeaPort port = getSeaPortByIndex(ship.parent);
			if (port != null) {
				port.getShips().add(ship);
				port.getQue().add(ship);				
			}
			return;
		} else {
			dock.setShip(ship);
			this.getSeaPortByIndex(dock.parent).getShips().add(ship);
		}

	}

	public void assignPerson(Person person) {
		this.getSeaPortByIndex(person.getParent()).getPerson().add(person);
	}

	public void assignDock(Dock dock) {
		int parent = dock.getParent();
		SeaPort port = this.getSeaPortByIndex(parent) ;
		port.getDocks().add(dock);
	}

	public void assignPort(SeaPort port) {
		this.ports.put(port.getIndex(), port);
	}
	
	public void assignJob (Job job) {
		this.getShipByIndex(job.getParent()).getJobs().add(job);
	}

	public String toString() {
		String str = "";
		System.out.println(ports.keySet());
		for (SeaPort port : ports.values()) {
			str += port.toString() + "\n";
		}
		return str;
	}
	
	public HashMap<Integer, SeaPort> getPorts() {
		return ports;
	}

	public void setPorts(HashMap<Integer, SeaPort> ports) {
		this.ports = ports;
	}

	public PortTime getTime() {
		return time;
	}

	public void setTime(PortTime time) {
		this.time = time;
	}
}
