import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;






class BackgroundPanel extends JPanel
{
    // The Image to store the background image in.
   public static final int XFRAME = 1594;
   public static final int YFRAME = 796;
   
   ImageIcon img;
   Image scaledImg;
   private Graphics mygraphics;
   private BufferedImage buffered;
   
   
   public int currentPlayer;
   public boolean allow_draw;
   public Color currentColor; 
   
   public City[] cities;
   public Player[] players;
   
   
   public BackgroundPanel(City[] cit, Player[] pla)
   {
        // Loads the background image and stores in img object.
      img = new ImageIcon("Final_Map.jpg");
      
      cities = cit;
      
      players = pla; 
      
      
      buffered = new BufferedImage(1594, 796, BufferedImage.TYPE_INT_RGB);
      
      mygraphics = buffered.getGraphics();
      
      this.addMouseListener(new Mouse());
      
      mygraphics.drawImage(img.getImage(), 0, 0 , 1594, 796, null);
      
      currentPlayer = 0; 
      Color redddd = new Color(255,0,0); 
      currentColor = redddd; 
      allow_draw = false;
      
   }
   

   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      //g.drawImage(scaledImg, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
      
      g.drawImage(buffered, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field

      System.out.println("paint");
      
   }
   
   public void clear_board(Graphics g)
   {
      g.drawImage(img.getImage(), 0, 0 , 1594, 796, null);
   }
   
   
   
     
   public void drawEverything()
   {
      clear_board(mygraphics);
      
      mygraphics.setColor(currentColor);
      int whereAtPlayerOne = players[0].get_player_city_index();
     
      int[] locsAt = find_location_ofcity(whereAtPlayerOne);
      
      int whereAtPlayerTwo = players[1].get_player_city_index();
      
      int[] locsAtTwo = find_location_ofcity(whereAtPlayerTwo);
      
      //System.out.println("X loc is at" + locsAt[0]);
      //System.out.println("Y loc is at"+locsAt[1]);
      mygraphics.setColor(players[0].get_player_color());
      mygraphics.drawRect(locsAt[0]+5, locsAt[1]-10,25,25);
      mygraphics.setColor(players[1].get_player_color()); 
      mygraphics.drawRect(locsAtTwo[1]+5,locsAtTwo[1]-10,20,25);
      
      
      int curr_blue = 0; 
      int curr_yellow = 0;
      
      
      int[] loc_this_city = new int[2];
      for(int k = 0; k < 4; k++)
      {
         curr_blue= cities[k].get_blue();
         curr_yellow = cities[k].get_yellow();
         
         loc_this_city = find_location_ofcity(k);
         
         
         for(int p = 0; p < curr_blue; p++)
         {
            Color sagsadg = new Color(0,0,255);
            mygraphics.setColor(sagsadg);
            mygraphics.fillRect((loc_this_city[0]+10)-20*p ,loc_this_city[1]-5, 15, 15);
         
         }
         
         for(int n = 0; n < curr_yellow; n++)
         {
            Color asgsg = new Color(252,244,3);
            mygraphics.setColor(asgsg);
            mygraphics.fillRect((loc_this_city[0]+10) - 20*n,(loc_this_city[1]-5) , 20, 20);
         
         }
         
      
      }
      
      
      repaint(); 
      
      
      
      
      
      
   
   
   
   }
   
   
   public void move_player(int xx, int yy)
   {
      //System.out.println("its moving");
      if(allow_draw)
      {
         
         System.out.println(currentPlayer + "is moving to");
         
         
         if( xx > 78 && xx < 129 &&  yy > 244 && yy < 264) //San Fran - city 0 
         {
          
            players[currentPlayer].movePlayer(cities[0],0); 
            
            
         }
         else if( xx > 345 && xx < 395 &&  yy > 210 && yy < 230) //Chicago  - city 1 
         {
           
            players[currentPlayer].movePlayer(cities[1],1); 
         }
         else if( xx > 220 && xx < 270 &&  yy > 210 && yy < 230) //Montreal -city 2 
         {
            players[currentPlayer].movePlayer(cities[2],2); 
         }
         else if( xx > 710  && xx < 760 &&  yy > 220 && yy < 240) // New York - city 3 
         {
          
            players[currentPlayer].movePlayer(cities[3],3); 
         }
         else if( xx > 638  && xx < 688 &&  yy > 275 && yy < 295) // Washington - city 4
         {
          
            players[currentPlayer].movePlayer(cities[4],4); 
         }
         else if( xx > 420  && xx < 470 &&  yy > 280 && yy < 300) // Atlanta - city 5
         {
          
            players[currentPlayer].movePlayer(cities[5],5); 
         }
         else if( xx > 120  && xx < 170 &&  yy > 335 && yy < 355) // LA - city 6
         {
          
            players[currentPlayer].movePlayer(cities[6],6); 
         }
         else if( xx > 310  && xx < 360 &&  yy > 365 && yy < 385) // Mexico City - city 7
         {
          
            players[currentPlayer].movePlayer(cities[7],7); 
         }
         else if( xx > 545  && xx < 595 &&  yy > 350 && yy < 370) // Miami - city 8
         {
          
            players[currentPlayer].movePlayer(cities[8],8); 
         }
         else if( xx > 525   && xx < 575 &&  yy > 430 && yy < 480) // Bogota - city 9
         {
          
            players[currentPlayer].movePlayer(cities[9],9); 
         }
         else if( xx > 450  && xx < 500 &&  yy > 530 && yy < 550) // Lima - city 10
         {
          
            players[currentPlayer].movePlayer(cities[10],10); 
         }
         else if( xx > 480  && xx < 530 &&  yy > 615 && yy < 635) // Santiago - city 11
         {
          
            players[currentPlayer].movePlayer(cities[11],11); 
         }
          else if( xx > 685  && xx < 735 &&  yy > 605 && yy < 625) // Buenos ares - city 12
         {
          
            players[currentPlayer].movePlayer(cities[12],12); 
         }
          else if( xx > 805  && xx < 855 &&  yy > 540 && yy < 560) // Sao Palo - city 13
         {
          
            players[currentPlayer].movePlayer(cities[13],13); 
         }
          else if( xx > 1105  && xx < 1155 &&  yy > 170 && yy < 190) // London - city 14
         {
          
            players[currentPlayer].movePlayer(cities[14],14); 
         }
          else if( xx > 1065   && xx < 1115 &&  yy > 260 && yy < 280) // Madrid  - city 15
         {
          
            players[currentPlayer].movePlayer(cities[15],15); 
         }
         
         
         
         else
         {
            System.out.println("Can't go there");
         }
         
         //mygraphics.setColor(currentColor);
         //mygraphics.drawRect(drawX,drawY,40,40);
         allow_draw = false;
         //repaint();
      }  

   
   
   
   }
   
   public int[] find_location_ofcity(int place)
   {
      int places[] = new int[2];
      
      if(place == 0) 
      {
         places[0] = 78;
         places[1] = 244;
      }
      else if(place == 1) //green 
      {
         places[0] = 345;
         places[1] = 210;
      }
      else if(place == 2) //blue 
      {
         places[0] = 220;
         places[1] = 210;
        
      }
      else if(place == 3) //orange
      {
         places[0] = 710;
         places[1] = 220;
      }
      else if(place == 4) //orange
      {
         places[0] = 638;
         places[1] = 275;
      }
      else if(place == 5) //orange
      {
         places[0] = 420;
         places[1] = 280;
      }
      else if(place == 6) //orange
      {
         places[0] = 120;
         places[1] = 335;
      }
      else if(place == 7) //orange
      {
         places[0] = 310;
         places[1] = 365;
      }
      else if(place == 8) //orange
      {
         places[0] = 545;
         places[1] = 350;
      }
      else if(place == 9) //orange
      {
         places[0] = 525;
         places[1] = 430;
      }
      else if(place == 10) //orange
      {
         places[0] = 450;
         places[1] = 530;
      }
      else if(place == 11) //orange
      {
         places[0] = 480;
         places[1] = 615;
      }
      else if(place == 12) //orange
      {
         places[0] = 685;
         places[1] = 605;
      }
       else if(place == 13) //orange
      {
         places[0] = 805;
         places[1] = 540;
      }
       else if(place == 14) //orange
      {
         places[0] = 1105;
         places[1] = 170;
      }
       else if(place == 15) //orange
      {
         places[0] = 1065;
         places[1] = 260;
      }
      
      return(places);
   
   
   
   }
   
   
   public void allow_move(boolean check)
   {
      allow_draw = check;
   
   }
   
   
   
   public void change_player(int playerr)
   {
      currentPlayer = playerr;
      /*
      if(playerr == 0)
      {
         currentColor = new Color(255,0,0);
      }
      else
      {
         currentColor = new Color(0,0,255);
         
      }
      */
   }
   
   
   
   
   
   
   private class Mouse extends MouseAdapter
   {
      public void mouseClicked(MouseEvent e)
      {
         //System.out.println( e.getX() , e.getY() );
         System.out.println(e.getX());
         System.out.println(e.getY());
         move_player(e.getX(), e.getY());
      }
   }
      
  
  
   

  
    
}





