import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GUIPanel extends JPanel{
   JTextField red;
   JTextField green;
   JTextField blue;
   JTextField height;
   JTextField width;
   
   TrianglePanel tri;
   public GUIPanel(){
      setLayout(new BorderLayout());
      
      tri = new TrianglePanel();
      add(tri, BorderLayout.CENTER);
      
      JLabel north_title = new JLabel("The Moving Triangle!");
      north_title.setFont(new Font("Serif", Font.BOLD, 20));
      north_title.setHorizontalAlignment(SwingConstants.CENTER);
      add(north_title, BorderLayout.NORTH);
      
      JButton bottom = new JButton("Reset with a new triangle!");
      bottom.addActionListener(new resetListener());
      add(bottom, BorderLayout.SOUTH);
      
      JPanel westSubPanel = new JPanel();
      westSubPanel.setLayout(new GridLayout(5, 2));
      
      JLabel redLabel = new JLabel("Red: ");
      redLabel.setHorizontalAlignment(JLabel.RIGHT);
      westSubPanel.add(redLabel);
      red = new JTextField("230", 10);
      red.setHorizontalAlignment(SwingConstants.CENTER);
      westSubPanel.add(red);
      
      JLabel greenLabel = new JLabel("Green: ");
      greenLabel.setHorizontalAlignment(JLabel.RIGHT);
      westSubPanel.add(greenLabel);
      green = new JTextField("120", 10);
      green.setHorizontalAlignment(SwingConstants.CENTER);
      westSubPanel.add(green);
       
      JLabel blueLabel = new JLabel("Blue: ");
      blueLabel.setHorizontalAlignment(JLabel.RIGHT);
      westSubPanel.add(blueLabel);
      blue = new JTextField("20", 10);
      blue.setHorizontalAlignment(SwingConstants.CENTER);
      westSubPanel.add(blue);
      
      JLabel heightLabel = new JLabel("Height: ");
      heightLabel.setHorizontalAlignment(JLabel.RIGHT);
      westSubPanel.add(heightLabel);
      height = new JTextField("10", 10);
      height.setHorizontalAlignment(SwingConstants.CENTER);
      westSubPanel.add(height);
      
      JLabel widthLabel = new JLabel("Width:");
      widthLabel.setHorizontalAlignment(JLabel.RIGHT);
      westSubPanel.add(widthLabel);
      width = new JTextField("40", 10);
      width.setHorizontalAlignment(SwingConstants.CENTER);
      westSubPanel.add(width);
      add(westSubPanel, BorderLayout.WEST);      
   } 
   private class resetListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         int convertedRed = Integer.parseInt(red.getText());
         int convertedGreen = Integer.parseInt(green.getText());
         int convertedBlue = Integer.parseInt(blue.getText());
         int convertedHeight = Integer.parseInt(height.getText());
         int convertedWidth = Integer.parseInt(width.getText());           
         Color newColor = new Color(convertedRed, convertedGreen, convertedBlue);
         tri.newTriangle(newColor, convertedHeight, convertedWidth);
         tri.requestFocusInWindow();
      }
   } 
}