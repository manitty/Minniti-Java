package Geometric;

public class testGeo {
public static void main(String[] args) {
	
	Triangle triangle = new Triangle("Red", true, 4.0, 2.3, 3.4);
    Circle circle = new Circle("Blue", false, 2.1);
    Rectangle rectangle = new Rectangle("Green", true, 2.5, 5.0);
    
    System.out.println(triangle.toString());
    System.out.println("\n" + circle.toString());
    System.out.println("\n" + rectangle.toString());
      }
}
