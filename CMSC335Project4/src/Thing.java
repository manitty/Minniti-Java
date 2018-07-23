


import java.util.Scanner;

public class Thing implements Comparable<Thing> {

	String name;
	int index;
	int parent;

	public Thing(Scanner scannerInput) {

		if (scannerInput != null) {
			name = scannerInput.next();
			index = scannerInput.nextInt();
			parent = scannerInput.nextInt();
		}
	}


	public int getIndex() {
		return index;
	}


	public String getName() {
		return name;
	}


	public int getParent() {
		return parent;
	}

	@Override
	public int compareTo(Thing o) {
		if (this.index > o.index)
			return 1;
		else if (this.index == o.index)
			return 0;
		else
			return -1;
	}

	@Override
	public String toString() {
		return name + " " + index;
	}
}
