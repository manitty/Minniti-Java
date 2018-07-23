



import java.util.Comparator;

public class ShipComparator implements Comparator<Ship> {

	private final String compareType;

	public ShipComparator(String compareType) {
		this.compareType = compareType;
	}


	public int compare(Ship o1, Ship o2) {
		switch (compareType.charAt(0)) {
		case 'l':
			return compareLength(o1, o2);
		case 'd':
			return compareDraft(o1, o2);
			
		case 'w':
			return compareWeight(o1, o2);
			
		case 'n':
			return compareName(o1, o2);
			
		default:
			 return compareWidth(o1, o2);
		
		}
	}

	public int compareDraft(Ship draftObject1, Ship draftObject2) {
		return new Double(draftObject1.getDraft()).compareTo(draftObject2.getDraft());
	}

	public int compareWeight(Ship weightObject1, Ship weightObject2) {
		return new Double(weightObject1.getWeight()).compareTo(weightObject2.getWeight());
	}

	public int compareLength(Ship shipLengthObject1, Ship shipLengthObject2) {
		return new Double(shipLengthObject1.getLength()).compareTo(shipLengthObject2.getLength());
	}

	public int compareName(Ship shipNameObject1, Ship shipNameObject2) {
		return shipNameObject1.getName().compareTo(shipNameObject2.getName());
	}

	public int compareWidth(Ship widthObject1, Ship widthObject2) {
		return new Double(widthObject1.getWidth()).compareTo(widthObject2.getWidth());
	}
}