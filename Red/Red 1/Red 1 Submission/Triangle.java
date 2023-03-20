import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Triangle{
   public int[] myXs;
   public int[] myYs;
   private int myWidth;
   private int myHeight;
   public Color myColor;
   int dx;
   int dy;
   
   public Triangle(Color c, int h, int w){
      myWidth = w;
      myHeight = h;
      myColor = c;
      myXs = new int[]{200 - (w/2), 200 + (w/2), 200};
      myYs = new int[]{380, 380, (380 - h)};
      dx = 0;
      dy = 0;
   }
   
   public void move(){
      for (int i = 0; i < 3; i++){
         myXs[i] += dx;
         myYs[i] += dy;
      }
   }
   
   public void shift(int change_dx, int change_dy){
      dx += change_dx;
      dy += change_dy;
   }
   
   public void draw(Graphics myBuffer){
      myBuffer.setColor(myColor);
      myBuffer.fillPolygon(myXs, myYs, 3);
   }
}