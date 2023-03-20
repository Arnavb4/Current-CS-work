import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class TrianglePanel extends JPanel
{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Triangle panel;
   
   public TrianglePanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      Color defaultColor = new Color(230, 120, 20);
      panel = new Triangle(defaultColor, 10, 40);
      myBuffer.fillPolygon(panel.Xs, panel.Ys, 3);
      panel.draw(myBuffer);
      repaint();
      setFocusable(true);
   }
   
   public void redoTriangle(int dx, int dy)
   {
      panel.triangleMove(dx, dy);
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      myBuffer.setColor(panel.personalColor);
      myBuffer.fillPolygon(panel.Xs, panel.Ys, 3);
      repaint();
   }
   
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   
   public void resetTriangle(Color inputNewColor, int inputHeight, int inputWidth)
   {
      panel = new Triangle(inputNewColor, inputHeight, inputWidth);
      myBuffer.fillPolygon(panel.Xs, panel.Ys, 3);
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      panel.draw(myBuffer);
      repaint();
   }
}