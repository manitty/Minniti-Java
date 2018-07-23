
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class yahtzeeGame extends JApplet implements ActionListener {
 
/**pgosdj'pglwd'pfsdpomberntgl23
gjrogeprwogewrpojfepwgew
pk
*This is a basic yahtzee game applet
*/
private static final long serialVersionUID = 1L;
/**
* 
*
* @param args
*/
//setting the array for the dice images
Image [] dice=new Image [6];
int [] a = new int[5];
 
Button roll = new Button ("Roll Dice");
Button display = new Button ("Display Score");
Button end = new Button ("End");
 
int totalscore;
int pressed;
 
public void init() {
setLayout(null);
 
//retrieving the images from the dice folder
dice[0] = getImage(getCodeBase(), "dice1.gif");
dice[1] = getImage(getCodeBase(), "dice2.gif");
dice[2] = getImage(getCodeBase(), "dice3.gif");
dice[3] = getImage(getCodeBase(), "dice4.gif");
dice[4] = getImage(getCodeBase(), "dice5.gif");
dice[5] = getImage(getCodeBase(), "dice6.gif");
 
 
roll.setBounds(150,350,100,20); //setting the placement of each button
add(roll);
display.setBounds(350,350,100,20);
add(display);
end.setBounds(250,385,100,20);
add(end);
roll.addActionListener(this);
display.addActionListener(this);
end.addActionListener(this);
 
 
}
//this method displays the buttons/dice
public void paint(Graphics g){
super.paint(g);
//if end button is fired, "Goodbye" is displayed
if (pressed == 3){
g.drawString ("Goodbye", 280, 110);
}
// if roll button is fired, the dice will roll
if (pressed == 1 ){
int c = 50;
g.drawString ("Lets play Yahtzee!", 271, 110);
for(int i = 0; i < 5; i++){
a[i] = (int)(Math.random() * 5);
g.drawImage(dice[a[i]],c, 150, 50, 75, this); //using array to set random numbers, then placing in image
c = c + 100; //call, the dice will display
a[i] = a[i] + 1;
}
 
}
// if display button is fired, the score will show
// used separate if statements because new dice would roll with an "or" condition in a single "if" statement
//causing the program not to run correctly
if (pressed == 2){
int total = 0;
for(int i = 0; i < 5; i++){
total = total + a[i];
}
g.drawString ("Score: " + total, 280, 450);
 
 
totalscore=calculateScore(g);
 
}
 
}
 

//Action Event method to determed what will happen when each button is fired
public void actionPerformed(ActionEvent e){
if (e.getSource()== roll)
pressed =1;
if (e.getSource()== display)
pressed =2;
if (e.getSource()== end)
pressed =3;
 
repaint();
}
 
//using five variables, in which each is set to math.random function, if else statements check to see if matching numbers occur
public int calculateScore(Graphics g){
 
int dice1 = (int)(Math.random() * 5);
int dice2 = (int)(Math.random() * 5);
int dice3 = (int)(Math.random() * 5);
int dice4 = (int)(Math.random() * 5);
int dice5 = (int)(Math.random() * 5);
 
//if statement to check for yahtzee
if(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 && dice4 == dice5)
{
totalscore = 50;
g.drawString("you have YAHTZEE!", 280, 500);
}
 
//if statement to check for a four of a kind
else if(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 || dice1 == dice2 && dice2 == dice3
&& dice3 == dice5 || dice1 == dice2 && dice2 == dice4 && dice4 == dice5 || dice1 == dice3
&& dice3 == dice4 && dice4 == dice5 || dice2 == dice3 && dice3 == dice4 && dice4 == dice5)
{
totalscore = dice1 + dice2 + dice3 + dice4 + dice5;
g.drawString("You have a four of a kind", 280, 500);
}
 
//if statement to check for a full house
else if((dice1 == dice2 && dice2 == dice3) && (dice4 == dice5) || (dice1 == dice2 && dice2 == dice4)
&& (dice3 == dice5) || (dice1 == dice2 && dice2 == dice5) && (dice2 == dice4) ||
(dice1 == dice3 && dice3 == dice4) && (dice2 == dice5) || (dice1 == dice3 && dice3 == dice5)
&& (dice2 == dice4) || (dice1 == dice4 && dice4 == dice5) && (dice2 == dice3) ||
(dice2 == dice3 && dice3 == dice4) && (dice1 == dice5) || (dice2 == dice3 && dice3 == dice5)
&& (dice1 == dice4) || (dice2 == dice4 && dice4 == dice5) && (dice1 == dice3) ||
(dice3 == dice4 && dice4 == dice5) && (dice1 == dice2))
{
totalscore = 25;
g.drawString("You have a full house", 280, 500);
}
 
//if statement to check for a three of a kind
else if(dice1 == dice2 && dice2 == dice3 || dice1 == dice2 && dice2 == dice4 || dice1 == dice2
&& dice2 == dice5 || dice1 == dice3 && dice3 == dice4 || dice1 == dice3 && dice3 == dice5 ||
dice1 == dice4 && dice4 == dice5 || dice2 == dice3 && dice3 == dice4 || dice2 == dice3
&& dice3 == dice5 || dice2 == dice4 && dice4 == dice5 || dice3 == dice4 && dice4 == dice5)
{
totalscore = dice1 + dice2 + dice3 + dice4 + dice5;
g.drawString("You have a three of a kind", 280, 500);
}
 
 
return totalscore;
}
}
