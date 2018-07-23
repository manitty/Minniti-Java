


import java.util.Scanner;


public class Skill extends Thing {

	private String skill;

	public Skill(Scanner scannerInput) {
		super(scannerInput);
		skill = scannerInput.next();
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


}
