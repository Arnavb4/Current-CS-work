public class TJStudent{
   
   //fields:
   private String name;
   private String year;
   private int age;
   
   //constructors:
   public TJStudent(){
      name = "TJ Student";
      year = "Freshman";
      age = 14;
   }
   public TJStudent(String customName, String customYear, int customAge){
      name = customName;
      if (customYear.equals("Freshman") || customYear.equals("Sophomore") || customYear.equals("Junior") || customYear.equals("Senior")){
         year = customYear;
      }
      else{
         System.out.println("Error: " + customYear + " is not a valid year.");
         year = "Freshman";
      }
      if (customAge > 10 && customAge < 20){
         age = customAge;
      }
      else{
         System.out.println("Error: " + customAge + " is not a valid age.");
         age = 14;
      }
   }
   
   // accessor & modifier instance methods:
   public String getName(){
      return name;
   }
   public String getYear(){
      return year;
   }
   public int getAge(){
      return age;
   }
   
   public void setYear(String setCustomYear){
      if (setCustomYear.equals("Freshman") || setCustomYear.equals("Sophomore") || setCustomYear.equals("Junior") || setCustomYear.equals("Senior")){
         year = setCustomYear;
      }
      else {
         System.out.println("Error: " + setCustomYear + " is not a valid year.");
      }
   }
   
   public void setAge(int setCustomAge){
      if (setCustomAge > 10 && setCustomAge < 20){
         age = setCustomAge;
      }
      else{
         System.out.println("Error: " + setCustomAge + " is not a valid age.");
      }
   }
   
   public void setName(String setCustomName){
      name = setCustomName;
   }
   
   // Additional instance methods:
   public boolean sameYear(TJStudent other){
      return other.getYear().equals(year);
   }
   public boolean sameAge(TJStudent other){
      return other.getAge() == age;
   }
   public void summarize(){
   System.out.print(name);
   System.out.print(" is a ");
   System.out.print(age);
   System.out.print("-year-old ");
   System.out.println(year + ".");
   }
}