
import java.util.Scanner;


public class CargoShip extends Ship{
    double cargoValue;
    double cargoVolume;
    double cargoWeight;

    public CargoShip(Scanner scannerInput) {
        super(scannerInput);
        cargoWeight=scannerInput.nextDouble();
        cargoVolume=scannerInput.nextDouble();
        cargoValue=scannerInput.nextDouble();
    }
    
    @Override
    public String toString() {
        return "Cargo Ship: "+name+" "+index;
    }

    
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
    

}
