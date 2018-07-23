

import java.util.Scanner;



public class PassengerShip extends Ship{
    int numberOfOccupiedRooms;
    int numberOfPassengers;
    int numberOfRooms;



    public PassengerShip (Scanner sc) {
      super (sc);
      if (sc.hasNextInt()) numberOfPassengers = sc.nextInt();
      if (sc.hasNextInt()) numberOfRooms = sc.nextInt();
      if (sc.hasNextInt()) numberOfOccupiedRooms = sc.nextInt();
   } 
    
    

    
    
    public int getNumberOfOccupiedRooms() {
        return numberOfOccupiedRooms;
    }

    public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
        this.numberOfOccupiedRooms = numberOfOccupiedRooms;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    
    public String toString () {
      String st = "Passenger ship: " + super.toString();
      if (jobs.size() == 0) 
         return st;
      for (Job mj: jobs) st += "\n       - " + mj;
      return st;
   } 
    
}
