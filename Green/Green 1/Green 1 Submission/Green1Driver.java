import javax.swing.JFrame;
public class Green1Driver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Green1");
      frame.setSize(400, 425);      
      frame.setLocation(520, 250); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Green1());
      frame.setVisible(true);
   }
}