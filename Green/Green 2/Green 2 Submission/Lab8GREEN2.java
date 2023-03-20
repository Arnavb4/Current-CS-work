import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab8GREEN2{
   public static void main(String[] args){ 
      JFrame frame = new JFrame("Green 2");
      frame.setSize(400, 425);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Green2Panel());
      frame.setVisible(true);
   }
}