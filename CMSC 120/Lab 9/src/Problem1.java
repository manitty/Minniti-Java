import javax.swing.JApplet;
import java.awt.*;
public class Problem1 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image dog; //setting the name of the image 
	public void init() {
		// get the dog image from the location of the class file
dog = getImage(getCodeBase(),"dog.jpg");}
public void paint(Graphics g) {
	super.paint(g);
// use the drawRect() method to draw dog house
g.drawRect(100 ,100 , 300, 250);
// use the following method to draw the dog image inside the dog house
// set the x, y, width and height where the image will be drawn.
g.drawImage(dog, 220, 250, 75, 100, this);

}	
}
