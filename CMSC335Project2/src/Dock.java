//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.Scanner;

public class Dock extends Thing{
    //Instance variables
    Ship ship;
    
    //constructor
    public Dock(Scanner sc) {
        super(sc);
    }
    
    //Getter and Setter Methods
    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
  //toString method prints dock and ship
    public String toString()
    {
        return "Dock: "+super.toString()+"\n  Ship: "+ship.toString();
    }
    
}
