
import java.util.Scanner;

public class PassengerShip extends Ship {
	private int numberOfOccupiedRooms;
	private int numberOfPassengers;
	private int numberOfRooms;

	public PassengerShip(Scanner scannerInput) {
		super(scannerInput);
		if (scannerInput.hasNextInt()) {
			numberOfPassengers = scannerInput.nextInt();
		}
		if (scannerInput.hasNextInt()) {
			numberOfRooms = scannerInput.nextInt();
		}
		if (scannerInput.hasNextInt()) {
			numberOfOccupiedRooms = scannerInput.nextInt();
		}

	}

	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	}


	public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
	}


	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}


	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String toString() {
		String st = "Passenger ship: " + super.toString();
		if (jobs.size() == 0) {
			return st;
		}
		for (Job mj : jobs) {
			st += "\n       - " + mj;
		}
		return st;
	}

}
