import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class Map_Maker
{

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame("Pandemic");
      frame.setSize(1920, 1080);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Game());
      frame.setVisible(true);
      
      
      
      
   }
}


