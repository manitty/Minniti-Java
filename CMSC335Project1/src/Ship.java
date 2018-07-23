//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ship extends Thing{
   
	//instance varibales
    PortTime arrivalTime,dockTime;
    double draft,length,weight,width;
    ArrayList<Job> jobs;

    //constructors
    public Ship(Scanner sc)
    {
        super(sc);
        weight=sc.nextDouble();
        length=sc.nextDouble();
        width=sc.nextDouble();
        draft=sc.nextDouble(); 
        jobs=new ArrayList<>();
    }
    
    
    
    //Getter & Setter Methods
    public PortTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(PortTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public PortTime getDockTime() {
        return dockTime;
    }

    public void setDockTime(PortTime dockTime) {
        this.dockTime = dockTime;
    }

    public double getDraft() {
        return draft;
    }

    public void setDraft(double draft) {
        this.draft = draft;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

   
    
    
    
}
