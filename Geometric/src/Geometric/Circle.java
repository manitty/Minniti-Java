package Geometric;

public class Circle extends GeometricObject{
	private double Radius;

	public Circle(String Color,boolean Filled, double Radius){
		super(Color,Filled);
		this.Radius = Radius;
	}
	
	public double getArea(){
		double area=0;
		area = Math.PI * Radius * Radius;
		return area;
	}

	public double getPerimeter(){
		double c = 0;
		c = 2 * Math.PI * Radius;
		return c;
	}
	
	public double getDiameter(){
		double diameter = 0;
		diameter = Radius + Radius;
		return diameter;
	}
	
	@Override
	public String toString(){
		return  "\nCircle" + super.toString() + "\nRadius: " + Radius +
				"\nDiameter: " + getDiameter() + 
				"\nArea: " + getArea() + 
				"\nPerimeter" + getPerimeter();
	}
		
	public double getRadius() {
		return Radius;
	}

	public void setRadius(double radius) {
		Radius = radius;
	}
}
