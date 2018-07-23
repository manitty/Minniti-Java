import java.util.Scanner;


public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		double [] temperature = new double [5];
		inputTemperature(temperature); 
		printTemperature(temperature);
		System.out.println();
		lowestTemperature(temperature);
		highestTemperature(temperature); 
		average(temperature); 
	}

	public static void inputTemperature (double[] values) {
		Scanner keyboard = new Scanner (System.in);
		for (int i = 0 ; i < 5; ++i ) {
			System.out.println("Input temperature " + i + ":");
			values[i] = keyboard.nextDouble();
		}
	}

	public static void printTemperature (double [] values) {
		for(int i = 0; i < 5; ++i){
			System.out.println("Temperature " + i + " is:" + values[i]);
		}
	} 
	public static void lowestTemperature (double [] values) {
		double min = values[0];
		for (int i = 1; i <5; ++i) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		System.out.println ("min: " + min);
	}
	public static void highestTemperature (double [] values) {
		double max = values[0];
		for (int i = 1; i <5; ++i) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		System.out.println ("max: " + max);
	}
	public static void average (double [] values) {
		double total = 0;
		for (int i = 0; i < 5; ++i) {
			total = total + values[i];
		}
		double average = total / 5;
		System.out.println("average: " + average);
	}


}