import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class TrianglePanel extends JPanel{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Triangle tri;
   private Timer t;
   private boolean up;
   private boolean left;
   private boolean right;
   private boolean down;
   
   public TrianglePanel(){
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      Color defaultColor = new Color(230, 120, 20);
      tri = new Triangle(defaultColor, 10, 40);
      myBuffer.fillPolygon(tri.myXs, tri.myYs, 3);
      tri.draw(myBuffer);
      repaint();
      addKeyListener(new Key());
      setFocusable(true);
      t = new Timer(5, new AnimationListener());
      up = false;
      right = false;
      down = false;
      left = false;
   }
   
   public void begin(){
      t.start();
   }
   
   public void animate(){
      tri.move();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      myBuffer.setColor(tri.myColor);
      myBuffer.fillPolygon(tri.myXs, tri.myYs, 3);
      repaint();
   }
   
   public void newTriangle(Color c, int h, int w){
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      tri = new Triangle(c, h, w);
      tri.draw(myBuffer);
      repaint();
   }
   
   public void paintComponent(Graphics g){
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   
   private class Key extends KeyAdapter{
      public void keyPressed(KeyEvent e){
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
         if (e.getKeyCode() == KeyEvent.VK_UP && !up){
            tri.shift(0, -2);
            up = true;
         }
         else if (e.getKeyCode() == KeyEvent.VK_RIGHT && !right){
            tri.shift(2, 0);
            right = true;
         }
         else if (e.getKeyCode() == KeyEvent.VK_DOWN && !down){
            tri.shift(0, 2);
            down = true;
         }
         else if (e.getKeyCode() == KeyEvent.VK_LEFT && !left){
            tri.shift(-2, 0);
            left = true;
         }  
      }
      
      public void keyReleased(KeyEvent e){
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
         if (e.getKeyCode() == KeyEvent.VK_UP && up){
            tri.shift(0, 2);
            up = false;
         }
         else if (e.getKeyCode() == KeyEvent.VK_RIGHT && right){
            tri.shift(-2, 0);
            right = false;
         }
         else if (e.getKeyCode() == KeyEvent.VK_DOWN && down ){
            tri.shift(0, -2);
            down = false;
         }
         else if (e.getKeyCode() == KeyEvent.VK_LEFT && left){
            tri.shift(2, 0);
            left = false;
         }
      }
   }
   
   private class AnimationListener implements ActionListener{
      public void actionPerformed (ActionEvent e){
         animate();
      }
   }
}