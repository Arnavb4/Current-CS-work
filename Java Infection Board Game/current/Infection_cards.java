import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;




public class Infection_cards
{

   City thisCity;
   String myDisease;
   ImageIcon card;
   public Infection_cards(City thisLoc,String Color_disease, ImageIcon cardy)
   {
      thisCity = thisLoc;
      myDisease = Color_disease; 
      card = cardy;
      
   
   
   }
   
   public void infect_my_city()
   {
      if(myDisease.equals("yellow"))
      {
         thisCity.infect_yellow();
      
      }
      if(myDisease.equals("blue"))
      {
         thisCity.infect_blue(); 
      }
           
   }
   
   public ImageIcon get_infection_cards_pic()
   {
      //ImageIcon pic = new ImageIcon(card);
      return card; 
   
   
   
   }
   
   










}