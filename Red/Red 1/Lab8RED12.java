import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Lab8RED12
{
    public static void main(String[] args)
   {
      JFrame frame = new JFrame("GUI + a graphics JFrame");
      frame.setSize(600, 400);      //In Windows, the menu bar at the top is 25 pixels tall...
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GUIPanel());    //...so we would expect the content pane to be 800x200.
      frame.setVisible(true);
   }
}

class GUIPanel extends JPanel
{
   JTextField red;
   JTextField green;
   JTextField blue;
   JTextField height;
   JTextField width;
   TrianglePanel tri;  //The subpanel containing graphics is a separate class we define

   public GUIPanel()
   {
      setLayout(new BorderLayout());
      
      JLabel title = new JLabel("The moving triangle!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      tri = new TrianglePanel();  //Put the graphics panel in the center
      add(tri);
      
      //Subpanel to specify R, G, B values
      JPanel westsubpanel = new JPanel();
      westsubpanel.setLayout(new GridLayout(5, 2));
      JLabel redLabel = new JLabel("Red: ");
      redLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      westsubpanel.add(redLabel);
      red = new JTextField("230", 10);
      red.setHorizontalAlignment(SwingConstants.CENTER);
      westsubpanel.add(red);
      JLabel greenLabel = new JLabel("Green: ");
      greenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      westsubpanel.add(greenLabel);
      green = new JTextField("120", 10);
      green.setHorizontalAlignment(SwingConstants.CENTER);
      westsubpanel.add(green);
      JLabel blueLabel = new JLabel("Blue: ");
      blueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      westsubpanel.add(blueLabel);
      blue = new JTextField("20", 10);
      blue.setHorizontalAlignment(SwingConstants.CENTER);
      westsubpanel.add(blue);
      JLabel heightLabel = new JLabel("Height: ");
      heightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      westsubpanel.add(heightLabel);
      height = new JTextField("10", 10);
      height.setHorizontalAlignment(SwingConstants.CENTER);
      westsubpanel.add(height);
      JLabel widthLabel = new JLabel("Width: ");
      widthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      westsubpanel.add(widthLabel);
      width = new JTextField("40", 10);
      width.setHorizontalAlignment(SwingConstants.CENTER);
      westsubpanel.add(width);
      add(westsubpanel, BorderLayout.WEST);
      
      
      //Button to reset triangle.
      JButton button = new JButton("Reset with a new triangle!");
      button.addActionListener(new TriangleListener());
      add(button, BorderLayout.SOUTH);      
   }
   
   private class TriangleListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int rInt = Integer.parseInt(red.getText());
         int gInt = Integer.parseInt(green.getText());
         int bInt = Integer.parseInt(blue.getText());
         int hInt = Integer.parseInt(height.getText());
         int wInt = Integer.parseInt(width.getText());
         Color c = new Color(rInt, gInt, bInt);
         tri.newTriangle(c, hInt, wInt);  //Action listener in GUIPanel calls a method in ExampleGraphicsPanel.
         tri.begin();
         tri.requestFocusInWindow();
      }
   }
}

class TrianglePanel extends JPanel
{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Triangle myTriangle;
   private Timer t;
   private boolean up;
   private boolean left;
   private boolean right;
   private boolean down;
      
   public TrianglePanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      Color orange = new Color(230, 120, 20);
      myTriangle = new Triangle(orange, 10, 40);
      myTriangle.drawTriangle(myBuffer);
      
      addKeyListener(new Key());  //Key listeners listen for keyboard inputs
      setFocusable(true);         //Need this in order to be able to receive keyboard input, along with .requestFocusInWindow() above
      
      t = new Timer(5, new AnimationListener());  //Once started, will call AnimationListener over and over; 5 millisecond delay each time
            
      up = false;
      left = false;
      right = false;
      down = false;     
   }
   
   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   
   public void begin()
   {
      t.start();  //Starts the timer!
   }
   
   public void newTriangle(Color c, int h, int w)  //This is called by the GUI panel when the user pushes the button.
   {  
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      
      myTriangle = new Triangle(c, h, w);
      myTriangle.drawTriangle(myBuffer);
      
      repaint();  //We don't write "paintComponent"; "repaint" calls "paintComponent" again automatically.
                  //(I know that's a bit confusing).
   }
   
   public void animate()
   {
      //Start over with a blank background
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      
      //Move the square (when we add multiple objects, they'll all need to move and draw)
      myTriangle.move();
      myTriangle.drawTriangle(myBuffer);
      
      //Call paintComponent
      repaint();
   }
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
   
   private class Key extends KeyAdapter  //This subpanel must have focus for keyboard input to register (see above)
   {
      public void keyPressed(KeyEvent e)  //We override this method; "e" contains a lot of information...
      {
      	myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0,0,FRAME,FRAME);
         
         //...including a Key Code, which will let us see which key the user pressed.  Check for '^':
         if(e.getKeyCode() == KeyEvent.VK_UP && !up)
         {
            myTriangle.up_down(-5);
            up = true;
         }
         //Check for '<':
         else if(e.getKeyCode() == KeyEvent.VK_LEFT && !left)
         {
            myTriangle.left_right(-5);
            left = true;
         }
         //Check for '>':
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT && !right)
         {
            myTriangle.left_right(5);
            right = true;
         }
         //Check for 'v':
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && !down)
         {
            myTriangle.up_down(5);
            down = true;
         }
      }
      public void keyReleased(KeyEvent e)  //Note keyReleased is called when... a key is released!
      {
      	// check for up arrow
         if(e.getKeyCode() == KeyEvent.VK_UP)
         {
            myTriangle.up_down(5);
            up = false;
         }
         //Check for '<':
         else if(e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            myTriangle.left_right(5);
            left = false;
         }
         //Check for '>':
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            myTriangle.left_right(-5);
            right = false;
         }
         //Check for 'v':
         else if(e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            myTriangle.up_down(-5);
            down = false;
         }
      }
   }
}

class Triangle
{
   private int[] myXs;
   private int[] myYs;
   private int myWidth;
   private int myHeight;
   private Color myColor;
   int mxdx;
   int mydy;
   
   public Triangle(Color c, int h, int w)
   {
      myWidth = w;
      myHeight = h;
      myColor = c;
      myXs = new int[]{200 - (myWidth/2), 200, 200 + (myWidth/2)};
      myYs = new int[]{380, 380 - myHeight, 380};
      mxdx = 0;
      mydy = 0;
   }
   
   public void move()
   {
      for (int i = 0; i < 3; i++)
      {
         myXs[i] += mxdx;
         myYs[i] += mydy;
      }     
   }
   
   public void up_down(int dy) //Allows the keyboard listener to modify animated behavior
   {
      mydy += dy;
   }
   
   public void left_right(int dx)
   {
      mxdx += dx;
   }
   
   public void drawTriangle(Graphics myBuffer)
   {
      myBuffer.setColor(myColor);
      myBuffer.fillPolygon(myXs, myYs, 3);
   }
}


