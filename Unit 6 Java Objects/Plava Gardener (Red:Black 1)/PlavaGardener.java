import java.util.Scanner;

public class PlavaGardener
{
   //Global variables
   //1) How are these like fields?  How are they different?
   public static int money;
   public static Scanner in;
   public static Plant[] plants;
   
   public static void reportAllStatus()
   {
      boolean some = false;
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null) //2) What is this line for?
         {
            some = true;
            System.out.println("In plot number " + i + ":");
            plants[i].statusReport();
            System.out.println("Expertise level: " + plants[i].getExpertise());
            System.out.println();
         }
      }
      System.out.println(plants[0].getOccupation());
      if(!some)
      {
         System.out.println("You don't have any plants!  Buy some at the store!");
      }
   }
   public static void waterAllPlants()
   {
      System.out.println("Most plants need somewhere between 0 and 2 tablespoons of water per day per 10 inches of height.");
      System.out.println("Plava plants might be unpredictable, though!");
      System.out.println("For each plant below, give a decimal value of tablespoons of water to give per day.");
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            if (plants[i].isAlive() == true){
               System.out.print("For plot number " + i + ", your " + plants[i] + " should get:");
               String inpt = in.nextLine();
               double water = Double.parseDouble(inpt);
               if (water < 0){
                  System.out.println("That is not a valid amount of water!");
               }
               else{
                  plants[i].setWater(water);
               }
            }
            else{
               System.out.println("Plant is dead :( Please choose another plant:");
            }  
         }
      }
   }
   public static void sunlightAllPlants()
   {
      System.out.println("You have three options for the sunlight each plant gets - direct, indirect, or shade.");
      System.out.println("For each plant below, either type what sunlight you'd like it to get, or just type 'x' if you want to leave it where it is.");
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            if (plants[i].isAlive() == true){
               System.out.println("For plot number " + i + ", your " + plants[i] + " is currently getting " + plants[i].getSunlight() + ".");
               System.out.print("Type a different option to change, or 'x' to keep as is: ");
               String inpt = in.nextLine();
               plants[i].setSunlight(inpt); //4) Why don't I need to check to see if inpt has a valid answer before calling this?
            }
            else{
               System.out.println("Plant is dead :( Please choose another plant:");
            }
         }
      }
   }
   public static void soundAllPlants()
   {
      System.out.println("You have three options for the sunlight each plant gets - loud, quiet, or none.");
      System.out.println("For each plant below, either type what noise you'd like it to get, or just type 'x' if you want to leave it where it is.");
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            if (plants[i].isAlive() == true){
               System.out.println("For plot number " + i + ", your " + plants[i] + " is currently getting " + plants[i].getSound() + ".");
               System.out.print("Type a different option to change, or 'x' to keep as is: ");
               String inpt = in.nextLine();
               plants[i].setSound(inpt); //4) Why don't I need to check to see if inpt has a valid answer before calling this?
            }
            else{
               System.out.println("Plant is dead :( Please choose another plant:");
            }
         }
      }
   }
   public static void occupationAllPlants()
   {
      System.out.println("You have four options for your occupation - climatologist, florist, bryologist, or dendrologist.");
      System.out.println("Either type what noise you'd like it to get, or just type 'x' if you want to leave it where it is.");
      if (plants[0].isAlive() == true){
         System.out.println("Your occupation is currently: " + plants[0].getOccupation() + ".");
         System.out.print("Type a different option to change, or 'x' to keep as is: ");
         String inpt = in.nextLine();
         plants[0].setOccupation(inpt); //4) Why don't I need to check to see if inpt has a valid answer before calling this?
      }
      else{
         System.out.println("Plant is dead :( Please choose another plant:");
      }
   }
   public static void growAllPlants()
   {
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            plants[i].grow(); 
         }
      }
   }
   public static Plant goShopping()
   {
      System.out.println("Welcome to the Plava plant store!");
      System.out.println("I currently have two options for sale.");
      System.out.println("1) Plava Rose -- $2");
      System.out.println("2) Plava Cactus -- $5");
      System.out.println("3) Plava Moss -- $3");
      System.out.println("4) Plava Tree -- $10");
      System.out.println("You currently have $" + money + ".");
      System.out.print("What would you like to buy (type the number of the option you choose or 0 to buy nothing)? ");
      String inpt = in.nextLine();
      int choice = Integer.parseInt(inpt);
      if(choice == 1 && money >= 2)
      {
         money -= 2;
         return new PlavaRose();
      }
      else if(choice == 2 && money >= 5)
      {
         money -= 5;
         return new PlavaCactus();
      }
      else if(choice == 3 && money >= 3)
      {
         money -= 3;
         return new PlavaMoss();
      }
      else if(choice == 4 && money >= 10)
      {
         money -= 10;
         return new PlavaTree();
      }
      System.out.println("You don't have enough money for that!");
      return null;
   }
   public static void gameLoop()
   {
      while(true)  //5) This looks like it will go on forever!  How does this loop end?
      {
         System.out.println();
         System.out.println("You can choose any of the following options:");
         System.out.println("1) Check on the status of your plants");
         System.out.println("2) Decide how much to water each plant this week");
         System.out.println("3) Decide how much sunlight to give each plant this week");
         System.out.println("4) Wait a week to see how your plants grow/don't grow");
         System.out.println("5) Buy a new plant from the store");
         System.out.println("6) Throw away a plant that you own");
         System.out.println("7) Cut a flower off of one of your plants and sell it");
         System.out.println("8) Decide how much sound to give each plant this week");
         System.out.println("9) Decide occupation (boosts blooms of certain plants)");
         System.out.println("0) Quit the game (your progress will not be saved)");
         System.out.print("Type the number of your choice: ");
         String inpt = in.nextLine();
         int choice = Integer.parseInt(inpt);
         if(choice == 1)
         {
            reportAllStatus();
         }
         else if(choice == 2)
         {
            waterAllPlants();
         }
         else if(choice == 3)
         {
            sunlightAllPlants();
         }
         else if(choice == 4)
         {
            System.out.println("A week passes.  Check your plant status to see how they did!");
            growAllPlants();
         }
         else if(choice == 5)
         {
            Plant temp = goShopping();
            if(temp != null)
            {
               int plot;
               boolean open_space = false;
               for(plot = 0; plot < plants.length; plot++)
               {
                  if(plants[plot] == null)
                  {
                     open_space = true;
                     plants[plot] = temp;
                     System.out.println("Your new plant is in plot #" + plot);
                     System.out.println();
                     break;
                  }
               }
               if(open_space == false){
                     System.out.println("There aren't enough spaces");
               }      
            }
         }
         else if(choice == 6)
         {
            System.out.print("Which plot would you like to throw away? ");
            String inpt2 = in.nextLine();
            int choice2 = Integer.parseInt(inpt2);
            plants[choice2] = null;
         }
         else if(choice == 7)
         {
            System.out.println("Choose which plant you would like to cut a flower from: ");
            String inpt3 = in.nextLine();
            int choice3 = Integer.parseInt(inpt3);
            int flowers_exist = plants[choice3].trim();
            if (flowers_exist == 0){
               System.out.println("There's no flowers to cut!");
            }
            else if (flowers_exist == 1){
                  money += plants[choice3].getValue();
                  System.out.println("Your money is now at: $" + money);
            }
            
         }
         else if (choice == 8){
            soundAllPlants();
         }
         else if (choice == 9){
            occupationAllPlants();
         }
         else
         {
            return;  //6) Why does this have nothing after it?  What does this do?
         }
      }
   }
   public static void main(String[] args)
   {
      //7) Over the next three lines, the variable types are NOT given.  Why?
      in = new Scanner(System.in);
      money = 10;
      plants = new Plant[10];
      
      System.out.println("Welcome to Plava Gardener!");
      gameLoop();
   }
}