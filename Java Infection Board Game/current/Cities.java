import java.util.HashMap;

public class HashMaper
{
   String[] cityNames;
   int[] standardVals;
   Player[] players[];
   
   public HashMaper(Player daplayer)
   {  
      players[0] = new Player(
      
      this);
      cityNames = new String[]{"Red", "Green", "Blue", "Orange"};
      HashMap <String, Array> hashMap = new HashMap <String, Array> ();
      standardVals = new int[]{0, 0, 0, 0, 0, 0, 0}; // red, yellow, blue, black, research station, player 1, player 2
       
      for (int i = 0; i < 4; i++)
      {
         hashMap.put(cityNames[i], standardVals);
      }
   } 
   
      
}