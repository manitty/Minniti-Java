package discussion;

public class Super {
	private String name;
	private int age;
	
	public Super(String name, int age){
		this.setName(name);
		this.age = age;
	}
	
	public String toString(){
		return "Name: " + getName() + "\nAge: " + age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
