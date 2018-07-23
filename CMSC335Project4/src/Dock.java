

import java.util.Scanner;

public class Dock extends Thing {

	private Ship ship;
	

	public Dock(Scanner scannerInput) {
		super(scannerInput);

	}
	
	public String toString() {
		return String.format("Dock: %s \n\tShip: %s\n", super.toString(), ship.toString());
	}


	public Ship getShip() {
		return ship;
	}


	public void setShip(Ship ship) {
		this.ship = ship;
	}

}
