import java.util.Scanner;
import java.util.Arrays;

public class Green2{
   
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.print("Please type a string: ");
      String s = in.nextLine();
      System.out.println("#1: " + s.substring(2, 3));
      System.out.println("#2: " + s.substring(4, 5));
      System.out.println("#3: " + s.length());
      System.out.println("#4: " + s.substring(0, 1));
      System.out.println("#5: " + s.substring(s.length() - 1, s.length()));
      System.out.println("#6: " + s.substring(s.length() - 2, s.length() - 1));
      System.out.println("#7: " + s.substring(3, 8));
      System.out.println("#8: " + s.substring(s.length() - 5, s.length()));
      System.out.println("#9: " + s.substring(3, s.length()));
      System.out.println("#10: " + s.toLowerCase());
      System.out.println("#11: " + s.toUpperCase());
      System.out.println("#12: " + Arrays.toString(s.toCharArray()));
      System.out.println("#13: " + s.substring(0, s.length() - 1));
      System.out.println("#14: " + s.substring(1, s.length()));
      int counter1 = 0;
      for (int i = 0; i < s.length(); i++){
         if (s.substring(i, i + 1).equals("e")){
            counter1++;
         }
      }
      System.out.println("#15: " + counter1);
      int counter2 = 0;
      for (int i = 0; i < s.length(); i++){
         if (s.substring(i, i + 1).equals("e")||s.substring(i, i + 1).equals("E")){
            counter2++;
         }
      }
      System.out.println("#16: " + counter2);
      int counter3 = 0;
      for (int i = 0; i < s.length(); i++){
         if (s.substring(i, i + 1).equals("e")||s.substring(i, i + 1).equals("E")|| s.substring(i, i + 1).equals("a")||s.substring(i, i + 1).equals("A")|| s.substring(i, i + 1).equals("i")||s.substring(i, i + 1).equals("I") || s.substring(i, i + 1).equals("o")||s.substring(i, i + 1).equals("O") || s.substring(i, i + 1).equals("u")||s.substring(i, i + 1).equals("U")){
            counter3++;
         }
      }
      System.out.println("#17: " + counter3);
      String str1 = "";
      for (int i = 0; i < s.length(); i++){
         if (s.substring(i, i + 1).equals("e")||s.substring(i, i + 1).equals("E")|| s.substring(i, i + 1).equals("a")||s.substring(i, i + 1).equals("A")|| s.substring(i, i + 1).equals("i")||s.substring(i, i + 1).equals("I") || s.substring(i, i + 1).equals("o")||s.substring(i, i + 1).equals("u") || s.substring(i, i + 1).equals("u")||s.substring(i, i + 1).equals("U")){
            str1 += s.substring(i, i + 1);
         }
      }
      String [] array1 = new String[str1.length()];
      for (int i = 0; i < str1.length(); i++){
         array1[i] = str1.substring(i, i + 1);
      }
      System.out.println("#18: " + Arrays.toString(array1));
      String str2 = "";
      for (int i = 0; i < s.length(); i++){
         if (i % 2 == 0){
            str2 += s.substring(i, i + 1);
         }
      }
      System.out.println("#19: " + str2);
      String str3 = "";
      for (int i = 0; i < s.length(); i++){
         if (i % 2 == 1){
            str3 += s.substring(i, i + 1);
         }
      }
      System.out.println("#20: " + str3);
      String [] array2 = new String[s.length() - 1];
      for (int i = 0; i < s.length() - 1; i++){
         array2 [i] = s.substring(i, i + 2);
      }
      System.out.println("#21: " + Arrays.toString(array2));
      String str4 = "";
      for (int i = 0; i < s.length(); i++){
         if (i % 3 == 0){
            str4 += "!";
         }
         else{
            str4 += s.substring(i, i + 1);
         }
      }
      System.out.println("#22: " + str4);
      String str5 = "";
      for (int i = 0; i < s.length(); i++){
         if (i % 3 == 2){
            str5 += "!";
         }
         else{
            str5 += s.substring(i, i + 1);
         }
      }
      System.out.println("#23: " + str5);
   }
   
  
}