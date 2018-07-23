
import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Cards extends JApplet implements ActionListener
{
Button deal = new Button ("Deal");
Image[] cards = new Image[13];
public void init()
{
setLayout(null);
cards[0]= getImage(getCodeBase(),"d1.gif");
cards[1] = getImage(getCodeBase(),"d2.gif)");
cards[2] = getImage(getCodeBase(),"d3.gif)");
cards[3] = getImage(getCodeBase(),"d4.gif)");
cards[4] = getImage(getCodeBase(),"d5.gif)");
cards[5] = getImage(getCodeBase(),"d6.gif)");
cards[6] = getImage(getCodeBase(),"d7.gif)");
cards[7] = getImage(getCodeBase(),"d8.gif)");
cards[8]= getImage(getCodeBase(),"d9.gif");
cards[9] = getImage(getCodeBase(),"d10.gif");
cards[10] = getImage(getCodeBase(),"dj.gif");
cards[11] = getImage(getCodeBase(),"dq.gif");
cards[12] = getImage(getCodeBase(),"dk.gif");

deal.setBounds(20, 240, 100, 20);
add(deal);
deal.addActionListener(this);
}
public void paint (Graphics g)
{
super.paint(g);
int totalvalue;
int[] random = new int [2];
System.out.print("Two Cards");
random [0] = 1 + (int) (Math.random() * 13);
random [1] = 1 + (int) (Math.random() * 13);
int x = random[0] - 1;
int y = random[1] - 1;
g.drawImage(cards[x], 220, 250, 75, 100, this);
g.drawImage(cards[y], 220, 250, 75, 100, this);
totalvalue = random[0] + random [1];
g.drawString("Total= "+totalvalue, 75, 100);
}
public void actionPerformed (ActionEvent e)
{
if(e.getSource() == deal)
repaint();
}
}
