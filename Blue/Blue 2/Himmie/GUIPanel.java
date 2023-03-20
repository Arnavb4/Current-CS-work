import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GUIPanel extends JPanel
{
   JTextField r;
   JTextField g;
   JTextField b;
   JTextField h;
   JTextField w;
   TrianglePanel panel;
   
   public GUIPanel()
   {
      setLayout(new BorderLayout());
      panel = new TrianglePanel();
      add(panel, BorderLayout.CENTER);
      
      JLabel n = new JLabel("The Moving Triangle!");
      n.setFont(new Font("Serif", Font.BOLD, 20));
      n.setHorizontalAlignment(SwingConstants.CENTER);
      add(n, BorderLayout.NORTH);
      
      JPanel west = new JPanel();
      west.setLayout(new GridLayout(5, 2));    
      JLabel red = new JLabel("Red: ");
      red.setHorizontalAlignment(JLabel.RIGHT);
      west.add(red);
      r = new JTextField("230", 10);
      r.setHorizontalAlignment(SwingConstants.CENTER);
      west.add(r);
      JLabel green = new JLabel("Green: ");
      green.setHorizontalAlignment(JLabel.RIGHT);
      west.add(green);
      g = new JTextField("120", 10);
      g.setHorizontalAlignment(SwingConstants.CENTER);
      west.add(g);
      JLabel blue = new JLabel("Blue: ");
      blue.setHorizontalAlignment(JLabel.RIGHT);
      west.add(blue);
      b = new JTextField("20", 10);
      b.setHorizontalAlignment(SwingConstants.CENTER);
      west.add(b);
      JLabel height = new JLabel("Height: ");
      height.setHorizontalAlignment(JLabel.RIGHT);
      west.add(height);
      h = new JTextField("10", 10);
      h.setHorizontalAlignment(SwingConstants.CENTER);
      west.add(h);
      JLabel width = new JLabel("Width:");
      width.setHorizontalAlignment(JLabel.RIGHT);
      west.add(width);
      w = new JTextField("40", 10);
      w.setHorizontalAlignment(SwingConstants.CENTER);
      west.add(w);
      add(west, BorderLayout.WEST);
      
      JPanel east = new JPanel();
      east.setLayout(new GridLayout(5, 3));
      JButton up = new JButton("^");
      up.addActionListener(new upListener());
      JButton right = new JButton(">");
      right.addActionListener(new rightListener());
      JButton down = new JButton("v");
      down.addActionListener(new downListener());
      JButton left = new JButton("<");
      left.addActionListener(new leftListener());
      JLabel blank_1 = new JLabel("");
      JLabel blank_2 = new JLabel("");
      JLabel blank_3 = new JLabel("");
      JLabel blank_4 = new JLabel("");
      JLabel blank_5 = new JLabel("");
      JLabel blank_6 = new JLabel("");
      JLabel blank_7 = new JLabel("");
      JLabel blank_8 = new JLabel("");
      JLabel blank_9 = new JLabel("");
      JLabel blank_10 = new JLabel("");
      JLabel blank_11 = new JLabel("");
      east.add(blank_1);
      east.add(blank_2);
      east.add(blank_3);
      east.add(blank_4);
      east.add(up);
      east.add(blank_5);
      east.add(left);
      east.add(blank_6);
      east.add(right);
      east.add(blank_7);
      east.add(down);
      east.add(blank_8);
      east.add(blank_9);
      east.add(blank_10);
      east.add(blank_11);
      add(east, BorderLayout.EAST);
      
      JButton downButton = new JButton("Reset with a new triangle!");
      downButton.addActionListener(new resetListener());
      add(downButton, BorderLayout.SOUTH);
   } 
   private class resetListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int newRed = Integer.parseInt(r.getText());
         int newGreen = Integer.parseInt(g.getText());
         int newBlue = Integer.parseInt(b.getText());
         int newHeight = Integer.parseInt(h.getText());
         int newWidth = Integer.parseInt(w.getText());           
         Color colorNew = new Color(newRed, newGreen, newBlue);
         panel.resetTriangle(colorNew, newHeight, newWidth);
         panel.requestFocusInWindow();
      }
   }
   
   private class upListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         panel.redoTriangle(0, -10);
      }
   }
   private class rightListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         panel.redoTriangle(10, 0);
      }
   }
   private class downListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         panel.redoTriangle(0, 10);
      }
   }
   private class leftListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         panel.redoTriangle(-10, 0);
      }
   } 
}