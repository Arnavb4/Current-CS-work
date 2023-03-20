import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;



public class Game extends JPanel 
{
   BackgroundPanel back;
   JTextField choice; 
   JLabel right;
   int player_turn;
   
   int moves_made;
   
   String move_options;
   
   public City[] cities;
   public Player[] players; 
   
   public boolean treating_rn;
   ArrayList<Location_cards> deck_location;
   
   Location_cards player_1_card_1;
   Location_cards player_1_card_2;
   Location_cards player_1_card_3;
   Location_cards player_1_card_4;
   Location_cards player_1_card_5;
   
   Location_cards player_2_card_1;
   Location_cards player_2_card_2;
   Location_cards player_2_card_3;
   Location_cards player_2_card_4;
   Location_cards player_2_card_5;
   
   JButton player_1_button_1;
   JButton player_1_button_2;
   JButton player_1_button_3;
   JButton player_1_button_4;
   JButton player_1_button_5;
   
   JButton player_2_button_1;
   JButton player_2_button_2;
   JButton player_2_button_3;
   JButton player_2_button_4;
   JButton player_2_button_5;
   
   ImageIcon blank_pic; 
   
   public Game()
   {
      
   
      cities = new City[17];   
      players = new Player[2];  
   
      Color redyy = new Color(255,0,0);
      Color blueyy = new Color(0,0,255);
      
      
      
      moves_made = 1; 
      move_options = "<html>press 1 to treat<br> press 2 to move right<br> press 3 to cure<br> press 4 to end turn<br> it is player 1's turn <br> you have a total of 4 moves";
      player_turn = 1;
      
      
      
      
      //iniate cities
      deck_location = new ArrayList<Location_cards>();
      
      for(int x = 0 ; x <17; x++)
      {
         cities[x] = new City();
         
      
      }
      //red =0
      //green = 1
      //blue = 2
      //orange = 3
      
      //initate location cards
      String diseaser = "blue";
      for(int x = 0; x <= 16; x++)
      {
         if(x > 5)
         {
            diseaser = "yellow";
         }
         
         
         
         ImageIcon pic = new ImageIcon("Location_card"+x+".jpg");
         Location_cards joe = new Location_cards(cities[x], diseaser, pic);
         deck_location.add(joe);
         
      }
      Collections.shuffle(deck_location);
      
      
      //formating 
      
      players[0] = new Player(redyy, cities[0]);
      players[1] = new Player(blueyy, cities[0]);
      cities[0].addPlayer(players[0]);
      cities[0].addPlayer(players[1]);
     
      back = new BackgroundPanel(cities,players);
      setLayout(new BorderLayout());
      add(back);
      
      JPanel subpanel = new JPanel();
      subpanel.setLayout(new GridLayout(2,1));
      
      right = new JLabel(move_options);
      right.setPreferredSize(new Dimension(250,100));
      subpanel.add(right);
      
      choice = new JTextField("0", 10);
      choice.setHorizontalAlignment(SwingConstants.CENTER);
      choice.addActionListener(new get_choice());
      subpanel.add(choice); 
      
      add(subpanel,BorderLayout.EAST);
      
      
      
      //west panel 
      ImageIcon location_blank_card = new ImageIcon("Location_card_backside.jpg");
      ImageIcon infection_blank_card = new ImageIcon("Infection_card_backside.jpg");
      
      Image blanker = location_blank_card.getImage() ;  
      Image newlocblank = blanker.getScaledInstance( 70, 120,  java.awt.Image.SCALE_SMOOTH ) ;  
      ImageIcon location_blank_cardr = new ImageIcon( newlocblank);
      
      Image joejoe = infection_blank_card.getImage() ;  
      Image newinfblank = joejoe.getScaledInstance( 70, 120,  java.awt.Image.SCALE_SMOOTH ) ;  
      ImageIcon infection_blank_cardr = new ImageIcon( newinfblank );
      
      
      JPanel Card_pile = new JPanel();
      Card_pile.setLayout(new GridLayout(4,1));
     
      
     
     
     
     
     
     
      //discard + draw piles 
      JButton Draw_1 = new JButton(location_blank_cardr);
      Draw_1.setPreferredSize(new Dimension(100, 50));
      
      JButton Discard_1 = new JButton(location_blank_cardr);
      Discard_1.setPreferredSize(new Dimension(100, 50));
      Discard_1.setText("Discard");
      Discard_1.setVerticalTextPosition(JButton.TOP);
      Discard_1.setHorizontalTextPosition(JButton.CENTER);
      JButton Draw_2 = new JButton(infection_blank_cardr);
      Draw_2.setPreferredSize(new Dimension(100, 50));
      JButton Discard_2 = new JButton(infection_blank_cardr);
      Discard_2.setPreferredSize(new Dimension(100, 50));
      Discard_2.setText("Discard");
      Discard_2.setVerticalTextPosition(JButton.TOP);
      Discard_2.setHorizontalTextPosition(JButton.CENTER);
      
      
      Card_pile.add(Draw_1);
      Card_pile.add(Discard_1);
      Card_pile.add(Draw_2);
      Card_pile.add(Discard_2); 
      add(Card_pile, BorderLayout.WEST); 
      
      
      
      blank_pic = new ImageIcon("Location_card_backside.jpg");
      
      Image joejoee = blank_pic.getImage() ;  
      Image newlocblankr = joejoee.getScaledInstance( 70, 120,  java.awt.Image.SCALE_SMOOTH ) ;  
      ImageIcon location_blank_cardrr = new ImageIcon( newlocblankr);
      blank_pic = location_blank_cardrr;
   
      player_1_card_1= new Location_cards(cities[16],"yellow", blank_pic); 

      player_1_card_2 = new Location_cards(cities[16],"yellow", blank_pic); 
      player_1_card_3 = new Location_cards(cities[16],"yellow", blank_pic); 
      player_1_card_4 = new Location_cards(cities[16],"yellow", blank_pic); 
      player_1_card_5 = new Location_cards(cities[16],"yellow", blank_pic); 
   
   
      Location_cards player_2_card_1 = new Location_cards(cities[16],"yellow", blank_pic); 
      Location_cards player_2_card_2 = new Location_cards(cities[16],"yellow", blank_pic); 
   
      Location_cards player_2_card_3 = new Location_cards(cities[16],"yellow", blank_pic); 
   
      Location_cards player_2_card_4 = new Location_cards(cities[16],"yellow", blank_pic); 
   
      Location_cards player_2_card_5 = new Location_cards(cities[16],"yellow", blank_pic); 
   
      
      
      
      //south panel 
      JPanel both_mat = new JPanel();
      
      both_mat.setLayout(new GridLayout(1,3));
      
      JPanel first_mat = new JPanel();
      first_mat.setLayout(new GridLayout(1,5)); 
      player_1_button_1 = new JButton(blank_pic);
      player_1_button_2 = new JButton(blank_pic);
      player_1_button_3 = new JButton(blank_pic);
      player_1_button_4 = new JButton(blank_pic);
      player_1_button_5 = new JButton(blank_pic);
      first_mat.add(player_1_button_1);
      first_mat.add(player_1_button_2);
      first_mat.add(player_1_button_3);
      first_mat.add(player_1_button_4);
      first_mat.add(player_1_button_5);
      
      both_mat.add(first_mat);
      JLabel tuu = new JLabel(" ");
      both_mat.add(tuu); 
      
      JPanel second_mat = new JPanel();
      second_mat.setLayout(new GridLayout(1,5)); 
      player_2_button_1 = new JButton(blank_pic);
      player_2_button_2 = new JButton(blank_pic);
      player_2_button_3 = new JButton(blank_pic);
      player_2_button_4 = new JButton(blank_pic);
      player_2_button_5 = new JButton(blank_pic);
      second_mat.add(player_2_button_1);
      second_mat.add(player_2_button_2);
      second_mat.add(player_2_button_3);
      second_mat.add(player_2_button_4);
      second_mat.add(player_2_button_5);
      
      both_mat.add(second_mat); 
      
      add(both_mat, BorderLayout.SOUTH); 
   
      
      
      
      Location_cards element = deck_location.get(0); 
      if (location_blank_cardr!=element.get_pic())
      {
         Discard_1.setIcon(element.get_pic()); 
      }
      
      
      
      
      infect_cities();
      back.drawEverything();  
     
   
   
   }
   
   public void play_Game()
   {
      while(moves_made < 4)
      {
      
         
      
      }
   
   }
   
   /*
   public void draw_infection_cards()
   {
              
      
   
   }
   */
   
   
   
   public void infect_cities()
   {
      int first = (int) (Math.random() * 4);
      int second = (int) (Math.random() * 4);
      int third = (int) (Math.random() * 4);
      cities[first].infect_blue();
      cities[second].infect_yellow();
      cities[third].infect_blue(); 
      
      
   
   }
   
   public void treat_city(String disease_type)
   {
      System.out.println("it is player's " + player_turn);
      City treated = (players[player_turn-1]).get_player_city();
      if(disease_type.equals("blue"))
      {
         treated.treat_blue();
      }
      else
      {
         treated.treat_yellow();
      }
      
        
   
   
   
   }
   
   //finish up 
   
   public void draw_location_cards()
   {  
      Location_cards element = deck_location.get(0); 
      
   
   
      
      if(player_1_card_1.check_empty())
      {
         deck_location.remove(0); 
         player_1_button_1.setIcon(element.get_pic()); 
         System.out.println("swapthis");
      } 
      if(player_1_card_2.check_empty())
      {
         deck_location.remove(0); 
         player_1_button_2.setIcon(element.get_pic()); 
      }
      if(player_1_card_2.check_empty())
      {
         deck_location.remove(0); 
         player_1_button_2.setIcon(element.get_pic()); 
      }
      if(player_1_card_2.check_empty())
      {
         deck_location.remove(0); 
         player_1_button_2.setIcon(element.get_pic()); 
      }
      if(player_1_card_2.check_empty())
      {
         deck_location.remove(0); 
         player_1_button_2.setIcon(element.get_pic()); 
      }  
      
     
      
   
   }
   
   
  
   
   
   
  
      


   private class get_choice implements ActionListener 
   {
      public void actionPerformed(ActionEvent e)
      {
         
         back.drawEverything();
         String move = choice.getText();
         if(treating_rn)
         {
            treat_city(move);
            treating_rn = false; 
         }
         
         else if(move.equals("2"))
         {
            back.allow_move(true);
         }
         else
         {
            back.allow_move(false);
         }
         
         
         
         
         
         if(move.equals("1"))
         {
            right.setText("Would you like to treat the blue or yellow disease");
            
            treating_rn = true; 
         
         }
         
         
         else if(moves_made <= 3)
         {
            right.setText(move_options + "<br>your selection was" + move + "<br>"+"player " + player_turn + " has made " + String.valueOf(moves_made) + " moves");
            moves_made+=1; 
         
         }
         else
         {
            right.setText(move_options + "<br>your selection was" + move + "<br>"+"player " + player_turn + " has made " + String.valueOf(moves_made) + " moves" + "<br> your turn is over and it is now the next player's turn");
            moves_made -=3; 
            if(player_turn == 1)
            {
               player_turn = 2; 
            }
            else
            {
               player_turn = 1; 
            }
         
            back.change_player(player_turn-1);
            infect_cities();
            
         }
         back.drawEverything();
         draw_location_cards();
         
         
         
         
         
         
      }
   
   
   }
   
   



}