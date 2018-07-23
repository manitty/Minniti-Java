package Geometric;

public class Triangle extends GeometricObject{
	private double side1 = 2.0;
	private double side2 = 2.0;
	private double side3 = 2.0;
	
	public Triangle(String Color,
					boolean Filled, 
					double side1,
					double side2, 
					double side3){
		super(Color,Filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getArea(){
		double area;
		area = (side1 + side2 + side3) / 2;
		return Math.sqrt(area * (area - side1) * (area - side2) * (area - side3));
	
	}
	
	public double getPerim(){
		double perim = 0;
		perim = side1+side2+side3;
		return perim;
	}
	
	@Override
	public String toString(){
		return  "\nTriangle" + super.toString() + "\nside1: " + side1 +
				"\nside2: " + side2 + 
				"\nside3: " + side3 + 
				"\nArea: " + this.getArea()
	               + "\nPerimeter: " + getPerim();
	}
	
	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
}
