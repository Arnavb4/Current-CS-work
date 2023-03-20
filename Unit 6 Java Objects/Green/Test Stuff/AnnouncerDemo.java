import java.util.Arrays;

public class AnnouncerDemo
{
   public static void main(String args[])
   {
      Announcer one = new Announcer();
      Announcer two = new Announcer("Python is great for lists!");
      one.announce();
      two.announce();
      
      System.out.println(one.getMessage());
      System.out.println(one.sameMessage(two));
      
      one.setMessage("Both have strengths and weaknesses!");
      one.announce();
      Announcer three = new Announcer("I like to yell", 6)
   }
}