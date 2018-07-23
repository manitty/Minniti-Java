package Geometric;

public class Rectangle extends GeometricObject {
	private double Width;
	private double Height;
	
	public Rectangle(String Color, boolean Filled, double Width, double Height){
		super(Color,Filled);
		this.Width = Width;
		this.Height = Height;
	}

	public double getArea(){
		double area=0;
		area = Width * Height;
		return area;
	}

	public double getPerimeter(){
		double perim = 0;
		perim = (Width * 2) + (Height * 2);
		return perim;
	}
	
	@Override
	public String toString(){
		return  "\nRectangle" + super.toString() + "\nWidth: " + Width +
				"\nHeight: " + Height + 
				"\nArea: " + getArea() + 
				"\nPerimeter" + getPerimeter();
	}
	
	public double getWidth() {
		return Width;
	}

	public void setWidth(double width) {
		Width = width;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}
}
