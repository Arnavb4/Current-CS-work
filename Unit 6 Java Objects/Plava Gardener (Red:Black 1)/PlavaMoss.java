public class PlavaMoss implements Plant
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
   private final int value = 3;  //9) What do you think is going on here?  What is "final"?  (Feel free to Google!)  Why is this value set outside the constructor?
   
   //Constructors
   public PlavaMoss()
   {
      height = 10;
      blooms = 0;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
      sound = "none";
      expertise = 0;
      occupation = "climatologist";
   }
   public PlavaMoss(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater, String customSound, String customOccupation)
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
   public String getSound(){
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
   public void setWater(double tablespoons)
   {
      //11) This isn't a very good modifier method.  Why?
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
      //12) Put into your own words: what does a Plava Rose need to bloom?
      if(stage >= 0)
      {
         if(sunlight.equals("shade"))
         {
            if((lastWater > 1.25 * height / 10 && lastWater < 1.75 * height / 10) && sound.equals("none"))
            {
               stage ++;
               expertise ++;
            }
         }
         if(sunlight.equals("direct") || sunlight.equals("indirect"))
         {
            stage --;
            expertise --;
         }
      }
      if(stage >= 5)
      {
         stage = 5;
         if (occupation.equals("bryologist")){
            blooms += 20;
         }
         else{
            blooms += 10;
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
         System.out.println("Your Plava Moss is dead!");
      else
      {
         System.out.println("Your Plava Moss is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Moss looks like a bare stalk.");
            System.out.println("Your expertise is not sufficient for additional information.");
         }
         else if(stage == 1 || stage == 2)
         {
            System.out.println("Your Plava Moss has grown a few leaves.");
            System.out.println("Expertise level 1: Plava Moss need shade");
         }
         else if(stage == 3 || stage == 4)
         {
            System.out.println("Your Plava Moss has a few flower buds.");
            System.out.println("Expertise level 2: Plava Moss need shade, 0.15 * height for water");
         }
         else if (stage > 4)
         {
            System.out.println("Your Plava Moss is blooming!");
            System.out.println("Expertise level 3: Plava Moss need shade, 0.15 * height for water, and no sound");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Moss";
   }
}