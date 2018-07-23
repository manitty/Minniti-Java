

import java.util.Scanner;

public class Person extends Thing {

	private String skill;

	public Person(Scanner scannerInput) {
		super(scannerInput);
		skill = scannerInput.next();
	}

	@Override
	public String toString() {
		return "Person: " + name + " " + index + " " + skill;
	}


	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
