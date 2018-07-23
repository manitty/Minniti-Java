//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.ArrayList;
import java.util.Scanner;

public class Job extends Thing{
    
	//instance variables
    double duration;
    ArrayList<String> requirements;

    //constructor
    public Job(Scanner sc) {
        super(sc);
    }

    
    //Getter & Setter Methods
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<String> requirements) {
        this.requirements = requirements;
    }
    
    
    
}
