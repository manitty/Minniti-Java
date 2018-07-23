package Geometric;

public class GeometricObject {
	private String Color;
	private boolean Filled;
	
	public GeometricObject(String Color, boolean Filled){
		this.Color = Color;
		this.Filled = Filled;
	}
	
	public String toString(){
		return "\nColor: " + Color + "\nFilled: " + Filled;
	}
	
	public String getColor() {
		return Color;
	}
	public void setColor(String Color) {
		this.Color = Color;
	}
	public boolean isFilled() {
		return Filled;
	}
	public void setFilled(boolean Filled) {
		this.Filled = Filled;
	}
	
}
