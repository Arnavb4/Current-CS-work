public class Announcer
{
   //fields:
   private String message;
   private int numTimes;
   
   //constructors:
   public Announcer()
   {
      message = "Java is awesome for object oriented programming!";
      numTimes = 1;
   }
   public Announcer(String customMessage)
   {
      message = customMessage;
   }
   
   public Announcer(String customMessage, int customNumTimes)
   {
      message = custommessage;
      numTimes = 1;
   }
   
   //accessor & modifier instance methods:
   public void setMessage(String customMessage)
   {
         message = customMessage;
   }
   public String getMessage()
   {
      return message;
   }
   
   public void setnumTimes(int customNumTimes)
   {
         numTimes = customNumTimes;
   }
   public int getNumTimes()
   {
      return numTimes;
   }
   
   //other instance methods:
   public boolean sameMessage(Announcer other)
   {
      return other.getMessage().equals(message);
   }
   public void announce()
   {
      for(int i = 0; i < numTimes; i++){
         System.out.println("I HAVE AN IMPORTANT ANNOUNCEMENT: " + message);
      }
}