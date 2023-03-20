import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JPanel
{
   public Start()
   {  
      setLayout(new GridLayout(2, 1));
      
      JLabel Title = new JLabel("Welcome to Pandemic.");
      Title.setFont(new Font("Serif", Font.BOLD, 80));
      Title.setHorizontalAlignment(SwingConstants.CENTER);
      
      JLabel StartTitle = new JLabel("Close out of this window to start your game!");
      StartTitle.setFont(new Font("Serif", Font.BOLD, 60));
      StartTitle.setHorizontalAlignment(SwingConstants.CENTER);
      add(Title);
      add(StartTitle);
   }
}