public class PlavaCactus implements Plant
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
   private final int value = 15;
   
   //Constructors
   public PlavaCactus()
   {
      height = 2;
      blooms = 0;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
      sound = "none";
      expertise = 0;
      occupation = "climatologist";
   }
   public PlavaCactus(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater, String customSound, String customOccupation)
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
   public String getSound(){
      return sound;
   }
   public String getOccupation(){
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
   public void setWater(double tablespoons)
   {
      lastWater = tablespoons;
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
   

   //Instance methods
   public void grow()
   {
      //13) Put into your own words - what does a Plava Cactus need to bloom?
      if(stage >= 0)
      {
         if(sunlight.equals("direct"))
         {
            if((lastWater > 0.2 * height / 10 && lastWater < 0.4 * height / 10) && sound.equals("quiet"))
            {
               height++;
            }
            if(height > (stage + 1) * 10)
            {
               stage++;
               expertise++;
            }
         }
         else
         {
            height--;
            expertise--;
            if(height == 0)
            {
               stage = -1;
            }
         }
      }
      if(stage >= 3)
      {
         stage = 3;
         if (occupation.equals("climatologist")){
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
         blooms--;
         return 1;
      }
      return 0;
   }
   public void statusReport()
   {
      if(stage == -1)
         System.out.println("Your Plava Cactus is dead!");
      else
      {
         System.out.println("Your Plava Cactus is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Cactus is a depressing looking nub.");
            System.out.println("Your expertise is not sufficient for additional information.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Cactus has split off a second stem and looks healthier.");
            System.out.println("Expertise level 1: Plava Cacti need direct sunlight");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Cactus has buds.");
            System.out.println("Expertise level 2: Plava Cacti need direct sunlight, and about 0.03 * height for water");
         }
         else
         {
            System.out.println("Your Plava Cactus is blooming!");
            System.out.println("Expertise level 3: Plava Cacti need direct sunlight, and about 0.03 * height for water, and quiet sound");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Cactus";
   }
}