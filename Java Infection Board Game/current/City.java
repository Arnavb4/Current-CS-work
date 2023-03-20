
public class City
{
   public int blueCubes;
   public int yellowCubes;
   public int blackCubes;
   public int redCubes;
   public boolean station;
   public Player[] currentPlayers;
   
   public City()
   {
      blueCubes = 0;
      yellowCubes = 0;
      blackCubes = 0;
      redCubes = 0; 
      station = false; 
      currentPlayers = new Player[2];
   
   }

   public void addPlayer(Player blah)
   {
      currentPlayers[0] = blah; 
   
   }
   
   public void infect_blue()
   {
      blueCubes+=1;
      if(blueCubes > 3)
      {
         blueCubes = 3;
      }
   }
   
   public void infect_yellow()
   {
      yellowCubes+=1;
      if(yellowCubes > 3)
      {
         yellowCubes = 3;
      }
   }
   
   public void treat_blue()
   {
      blueCubes-=1;
      if(blueCubes < 0 )
      {
         blueCubes = 0;
      }
   
   }
   
   public void treat_yellow()
   {
      yellowCubes-=1; 
      if(yellowCubes < 0)
      {
         yellowCubes = 0;
      }  
      
   
   }
   
   
   
   
   

   public int get_blue()
   {
      return blueCubes;
   }
   
   public int get_yellow()
   {
      return yellowCubes;
   }

   public void add_city()
   {
      station = true; 
   }



}