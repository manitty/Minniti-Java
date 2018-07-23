//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.ArrayList;
import java.util.Scanner;

public class SeaPort extends Thing{
    
	//Instance variables
     ArrayList <Dock> docks;
     ArrayList <Ship> ships;
     ArrayList <Ship> que;
     ArrayList <Person>  persons;

     //constructor
    public SeaPort(Scanner sc) {
        super(sc);
        docks=new ArrayList<>();
        ships=new ArrayList<>();
        que=new ArrayList<>();
        persons=new ArrayList<>();
    }

     
     //Getter & Setter Methods
    public ArrayList<Dock> getDocks() {
        return docks;
    }

    public void setDocks(ArrayList<Dock> docks) {
        this.docks = docks;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public ArrayList<Ship> getQue() {
        return que;
    }

    public void setQue(ArrayList<Ship> que) {
        this.que = que;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
     
    
     
     //toString Method prints seaport, ships in que, ships, persons.
     public String toString () {
      String st = "\n\nSeaPort: " + super.toString();
      for (Dock md: docks) st += "\n" + md;
      st += "\n\n --- List of all ships in que:";
      for (Ship ms: que ) st += "\n   > " + ms;
      st += "\n\n --- List of all ships:";
      for (Ship ms: ships) st += "\n   > " + ms;
      st += "\n\n --- List of all persons:";
      for (Person mp: persons) st += "\n   > " + mp;
      return st;
   } // end method toString
}
