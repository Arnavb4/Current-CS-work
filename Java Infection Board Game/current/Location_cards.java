import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class Location_cards
{
   City card_city;
   String disease_type;
   ImageIcon pic; 
   public Location_cards(City its_city, String disease_typer,ImageIcon location_blank_card )
   {  
     card_city = its_city;  
     disease_type = disease_typer; 
     
     
     Image blanker = location_blank_card.getImage() ;  
     Image newlocblank = blanker.getScaledInstance( 70, 120,  java.awt.Image.SCALE_SMOOTH ) ;  
     ImageIcon location_blank_cardr = new ImageIcon( newlocblank);
     
     pic = location_blank_cardr; 
     
   }
   
   public City fly_to_city()
   {
      return card_city; 
   }
   
   
   public String get_disease_type()
   {
      return disease_type; 
   }
   
   
   
   public ImageIcon get_pic()
   {
      return pic; 
   }
   
   public boolean check_empty()
   {
      ImageIcon blank_pic = new ImageIcon("Location_card_backside.jpg");
      Image blanker = blank_pic.getImage() ;  
      Image newlocblank = blanker.getScaledInstance( 70, 120,  java.awt.Image.SCALE_SMOOTH ) ;  
      ImageIcon location_blank_cardr = new ImageIcon( newlocblank);
      
      blank_pic = location_blank_cardr;

      if(blank_pic == pic)
      {
         return true;
      }
      else
      {
         return false; 
      }

      
   }






}