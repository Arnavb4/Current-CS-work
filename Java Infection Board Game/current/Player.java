import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;



public class Player
{  
   City mycity;
   private Color myColor;
   int city_index;
   

   public Player(Color Colory, City thisCity)
   {
      myColor = Colory; 
      thisCity = mycity;
      city_index = 0; 
   
   }
   

   
  
   public void movePlayer(City newCity, int UbiEst)
   {
      
      mycity = newCity;
      
      city_index = UbiEst; 
       
      /*
      red x: goes from 123-386
      red y: goes from 59-368
      green x: 874-1130
      green y: 36-344
      orange x: 343-586
      orange y: 432-742
      blue x: 763-1020
      blue y: 446 - 751
      */
      
      
   
   }
   
   public City get_player_city()
   {
      return mycity; 
   }
   
   
   
   public int get_player_city_index()
   {
      System.out.println("i am at " + city_index);
      return city_index; 
   }
   
   public Color get_player_color()
   {
      return myColor; 
   }



}