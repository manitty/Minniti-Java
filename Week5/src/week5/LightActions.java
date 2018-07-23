package week5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightActions extends JFrame
{
   private JButton okButton = new JButton("OK");

   public LightActions()
   {
       add(okButton);
       okButton.addActionListener(
               new ActionListener()
               {
                   @Override
                   public void actionPerformed(ActionEvent ae)
                   {
                       System.out.println("The OK button is clicked");
                   }
               });
   }
   public static void main(String[] args)
   {
       JFrame frame = new LightActions();
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}