//File name: Thing.java
//Author: Paul Minniti
//Date: 4 June 2017

import java.util.Scanner;

public class CargoShip extends Ship{
    double cargoValue;
    double cargoVolume;
    double cargoWeight;

    //constructor
    public CargoShip(Scanner sc) {
        super(sc);
        cargoWeight=sc.nextDouble();
        cargoVolume=sc.nextDouble();
        cargoValue=sc.nextDouble();
    }

    
    //Getter & Setter Methods
    public double getCargoValue() {
        return cargoValue;
    }

    public void setCargoValue(double cargoValue) {
        this.cargoValue = cargoValue;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
    
    //toSting Override Method prints name and index
    @Override
    public String toString()
    {
        return "Cargo Ship: "+name+" "+index;
    }
}
