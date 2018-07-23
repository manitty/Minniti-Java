package discussion;

public class Sub extends Super {
	private char Gender;
	
	public Sub(String name, int age, char Gender){
		super(name, age);
		this.Gender = Gender;
		
	}


	public String toString(){
		return "Name: " + getName()
				+ "Age: " + getAge()
				+ "Gender: " + Gender;
	}
	
	public char getGender() {
		return Gender;
	}

	public void setGender(char Gender) {
		this.Gender = Gender;
	}
}
