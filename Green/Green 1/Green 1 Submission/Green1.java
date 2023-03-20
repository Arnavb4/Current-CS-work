import javax.swing.*;
import java.awt.*;
public class Green1 extends JPanel{
   public void paintComponent(Graphics g){
      g.setColor(new Color(135, 206, 235));  	
      g.fillRect(0, 0, 400, 400);  
   	
      g.setColor(new Color(0, 64, 128));      
      g.fillRect(0, 300, 400, 100);						
      
      g.setColor(new Color(210, 105, 30).darker());
      g.drawRect(75, 200, 200, 100);
      
      g.setColor(Color.BLACK);
      g.drawOval(130, 205, 90, 90);
      
      g.setColor(new Color(210, 105, 30).darker());
      int xPoints[] = {130, 130, 175, 175};			
      int yPoints[] = {100, 200, 200, 175};			
      g.drawPolygon(xPoints, yPoints, 4);
      
      g.setColor(Color.BLACK);
      int xPoints1[] = {130, 175, 275, 275};			
      int yPoints1[] = {100, 175, 175, 100};
      g.fillPolygon(xPoints1, yPoints1, 4);
      
      for(int x = 5; x < 120; x+=20){  
         g.drawLine(x, 150, x + 5, 155);
         g.drawLine(x + 5, 155, x + 10, 150);
      }
      
      g.setColor(Color.YELLOW);
      g.fillOval(20, 20, 75, 75);
         
      g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));  
      g.setColor(Color.GREEN.darker());
      g.drawString("DAAA BOATTT", 135, 255); 
      
      g.setFont(new Font("Monospaced", Font.BOLD, 16));  
      g.setColor(Color.MAGENTA.darker());
      g.drawString("This is a picture of a boat!", 110, 60);
   }
}