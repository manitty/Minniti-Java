

import java.util.ArrayList;
import java.util.Scanner;


public class SeaPort extends Thing{
    
     ArrayList <Dock> docks;
     ArrayList <Ship> ships;
     ArrayList <Ship> que;
     ArrayList <Person>  persons;

    public SeaPort(Scanner sc) {
        super(sc);
        docks=new ArrayList<>();
        ships=new ArrayList<>();
        que=new ArrayList<>();
        persons=new ArrayList<>();
    }

     
     
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
     
    
     
     
     public String toString () {
      String st = "\nSeaPort: " + super.toString();
      for (Dock dk: docks) st += "\n" + dk;
      st += "\n --- List of all ships in que:";
      for (Ship sh: que ) st += "\n   ---> " + sh;
      st += "\n\n --- List of all ships:";
      for (Ship ash: ships) st += "\n   --->" + ash;
      st += "\n\n --- List of all persons:";
      for (Person np: persons) st += "\n   " + np;
      return st;
   }
}
