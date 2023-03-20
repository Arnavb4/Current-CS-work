import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Green2Panel extends JPanel{
   JTextField userInEast;  
   JTextField userInWest;
   JLabel finalNum;
   double num;
   
   public Green2Panel(){
      setLayout(new BorderLayout());
      
      num = 0;
      finalNum = new JLabel("" + num);
      finalNum.setFont(new Font("Serif", Font.BOLD, 80));
      finalNum.setHorizontalAlignment(SwingConstants.CENTER);
      add(finalNum);
      
      JLabel north_title = new JLabel("Lab 8-GREEN-02!");
      north_title.setFont(new Font("Serif", Font.BOLD, 20));
      north_title.setHorizontalAlignment(SwingConstants.CENTER);
      add(north_title, BorderLayout.NORTH);
      
      JPanel southSubpanel = new JPanel();
      southSubpanel.setLayout(new GridLayout(1, 4));
      JButton Add = new JButton("Add");
      Add.addActionListener(new AddListener());
      southSubpanel.add(Add);
      JButton Subtract = new JButton("Subtract");
      Subtract.addActionListener(new SubtractListener());
      southSubpanel.add(Subtract);
      JButton Multiply = new JButton("Multiply");
      Multiply.addActionListener(new MultiplyListener());
      southSubpanel.add(Multiply);
      JButton Divide = new JButton("Divide");
      Divide.addActionListener(new DivideListener());
      southSubpanel.add(Divide); 
      add(southSubpanel, BorderLayout.SOUTH);
      
      
      JPanel eastSubpanel = new JPanel();
      eastSubpanel.setLayout(new GridLayout(2, 1));
      JLabel blank = new JLabel("Enter a number:");
      blank.setVerticalAlignment(JLabel.BOTTOM);
      userInEast = new JTextField("0", 10);
      userInEast.setHorizontalAlignment(SwingConstants.CENTER);
      eastSubpanel.add(blank);
      eastSubpanel.add(userInEast);
      add(eastSubpanel, BorderLayout.EAST);
      
      
      JPanel westSubpanel = new JPanel();
      westSubpanel.setLayout(new GridLayout(2, 1));
      JLabel blank1 = new JLabel("Enter a number:");
      blank1.setVerticalAlignment(JLabel.BOTTOM);
      userInWest = new JTextField("0", 10);
      userInWest.setHorizontalAlignment(SwingConstants.CENTER);
      westSubpanel.add(blank1);
      westSubpanel.add(userInWest);
      add(westSubpanel, BorderLayout.WEST);
      
   }
   private class AddListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double newVal = Double.parseDouble(userInWest.getText()) + Double.parseDouble(userInEast.getText());
         num = newVal;
         finalNum.setText("" + num);
      }
   }
      
   private class SubtractListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double newVal = Double.parseDouble(userInWest.getText()) - Double.parseDouble(userInEast.getText());
         num = newVal;
         finalNum.setText("" + num);
      }
   }
      
   private class MultiplyListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double newVal = Double.parseDouble(userInWest.getText()) * Double.parseDouble(userInEast.getText());
         num = newVal;
         finalNum.setText("" + num);
      }
   }
      
   private class DivideListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         double newVal = Double.parseDouble(userInWest.getText()) / Double.parseDouble(userInEast.getText());
         num = newVal;
         finalNum.setText("" + num);
      }
   }
}
