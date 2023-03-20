    //Torbert, e-mail: smtorbert@fcps.edu	
	 //version 6.17.2003

   import javax.swing.JFrame;
    public class GraphicsExampleDriver
   {
       public static void main(String[] args)
      {
         JFrame frame = new JFrame("Build a House");
         frame.setSize(400, 425);      //In Windows, the menu bar at the top is 25 pixels tall... (and Macccc)
         frame.setLocation(100, 50); //My built-in display is 1440 x 900 so my max is 1040 x 500 middle would be 520 x 250
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new ExamplePanel());    //...so we would expect the content pane to be 400x400.
         frame.setVisible(true);
      }
   }