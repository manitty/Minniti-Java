//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.Scanner;

public class Person extends Thing{
    
	//instance variables
    String skills;

    //constructor
    public Person(Scanner sc)
    {
        super(sc);
        skills=sc.next();
    }

    //Getter & Setter Methods
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    //toString Override Method Prints: person, name, index, skills
    @Override
    public String toString()
    {
        return "Person: "+name+" "+index+" "+skills;
    }
    
}
