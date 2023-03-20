import java.util.Arrays;

public class InsertionSorter extends MeasureSorter {
   public InsertionSorter(String filename) throws Exception {
      super(filename);
   }
   public void sortMe(){
      for (int i = 1; i < measures.length; i++){
         System.out.println("i: " + Arrays.toString(measures));
         int curr_i = i;
         if (measures[i].compareTo(measures[i - 1]) == -1){
               while (curr_i > 0 && measures[curr_i].compareTo(measures[curr_i - 1]) < 0){
                  swap (curr_i, curr_i - 1);
                  curr_i--;
               }
         }
      }
      System.out.println("i: " + Arrays.toString(measures));      
    }
}
