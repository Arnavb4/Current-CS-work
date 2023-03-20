import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Triangle{
   public int[] Xs;
   public int[] Ys;
   private int personalW;
   private int personalH;
   public Color personalColor;
   
   public Triangle(Color colorr, int constructorHeight, int constructorWidth)
   {
      personalH = constructorHeight;
      personalW = constructorWidth;
      personalColor = colorr;
      Xs = new int[]{200 - (personalW/2), 200 + (personalW/2), 200};
      Ys = new int[]{380, 380, (380 - personalH)};
   }
   
   public void triangleMove(int changex, int changey)
   {
      for (int i = 0; i < 3; i++)
      {
         Xs[i] += changex;
         Ys[i] += changey;
      }
   }
   
   public void draw(Graphics myBuffer){
      myBuffer.setColor(personalColor);
      myBuffer.fillPolygon(Xs, Ys, 3);
   }
}