public class PlavaTree implements Plant
{
   //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private String sound;
   private String occupation;
   private int expertise;
   private double lastWater;
   private final int value = 20;  //9) What do you think is going on here?  What is "final"?  (Feel free to Google!)  Why is this value set outside the constructor?
   
   //Constructors
   public PlavaTree()
   {
      height = 10;
      blooms = 1;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
      sound = "none";
      expertise = 0;
      occupation = "climatologist";
   }
   public PlavaTree(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater, String customSound, String customOccupation)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
      sound = customSound;
      expertise = 0;
      occupation = customOccupation;
   }
   
   //Accessors & modifiers
   //10) Several accessors and modifiers are missing - why?
   public int getHeight()
   {
      return height;
   }
   public int getBlooms()
   {
      return blooms;
   }
   public String getSunlight()
   {
      return sunlight;
   }
   public String getSound()
   {
      return sound;
   }
   public String getOccupation()
   {
      return occupation;
   }
   public int getValue()
   {
      return value;
   }
   public int getExpertise(){
      return expertise;
   }
   public void setSunlight(String newSun)
   {
      if(newSun.equals("shade") || newSun.equals("indirect") || newSun.equals("direct"))
      {
         sunlight = newSun;
      }
   }
   public void setSound(String newSound)
   {
      if(newSound.equals("loud") || newSound.equals("quiet") || newSound.equals("none"))
      {
         sound = newSound;
      }
   }
   public void setOccupation(String newOccupation)
   {
      if(newOccupation.equals("climatologist") || newOccupation.equals("florist") || newOccupation.equals("dendrologist") || newOccupation.equals("bryologist"))
      {
         occupation = newOccupation;
      }
   }
   public void setWater(double tablespoons)
   {
      //11) This isn't a very good modifier method.  Why?
      lastWater = tablespoons;
   }

   //Instance methods
   public void grow()
   {
      //12) Put into your own words: what does a Plava Rose need to bloom?
      if(stage >= 0)
      {
         if(sunlight.equals("direct"))
         {
            if((lastWater > 1.5 * height / 10 && lastWater < 2.0 * height / 10) && sound.equals("loud"))
            {
               stage ++;
               expertise ++;
               height += 15;
            }
         }
         if(sunlight.equals("shade"))
         {
            stage --;
            expertise --;
            height -= 10;
         }
      }
      if(stage >= 4)
      {
         stage = -1;
         if (occupation.equals("dendrologist")){
            blooms += 2;
         }
         else{
            blooms += 1;
         }
      }
   }
   public int trim()
   {
      if(blooms > 0)
      {
         return 1;
      }
      return 0;
   }
   public void statusReport()
   {
      if(stage == -1)
         System.out.println("Your Plava Tree is dead!");
      else
      {
         System.out.println("Your Plava Tree is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Tree looks like a bare stalk.");
            System.out.println("Your expertise is not sufficient for additional information.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Tree has grown a few leaves.");
            System.out.println("Expertise level 1: Plava Trees need direct sunlight");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Tree has a few flower buds.");
            System.out.println("Expertise level 2: Plava Trees need direct sunlight, 0.175 * height for water");
         }
         else
         {
            System.out.println("Your Plava Tree is blooming!");
            System.out.println("Expertise level 3: Plava Trees need direct sunlight, 0.175 * height for water, and loud noise");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Tree";
   }
}