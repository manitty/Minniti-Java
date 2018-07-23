


import java.util.ArrayList;
import java.util.Scanner;



public class Ship extends Thing {
	private PortTime arrivalTime, dockTime;
	private double draft, length, weight, width;
	protected ArrayList<Job> jobs = new ArrayList<Job>();

	public Ship(Scanner scannerInput) {
		super(scannerInput);
		weight = scannerInput.nextDouble();
		length = scannerInput.nextDouble();
		width = scannerInput.nextDouble();
		draft = scannerInput.nextDouble();
	}
	

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
