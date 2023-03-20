import java.util.Arrays;

public class ShellSorter extends MeasureSorter{
   
   public ShellSorter(String filename) throws Exception
   {
      super(filename);
   }
   
   public void shellsortfunction(){
      for (int gap = measures.length/2; gap > 0; gap/= 2){
         /*for (int i = 0; i < gap; i++){
            for (int j = i+gap; j<measures.length && (measures[j].compareTo(measures[j-gap]) < 0); j += gap){
               swap(j, j-gap);
            }
         }
         System.out.println(Arrays.toString(measures));
         */
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
      }
   }
   
   public void sortMe(){
      System.out.println(Arrays.toString(measures)); //print the starting state of the array
      int N = measures.length;
      
      shellsortfunction();
                             //I correctly place N - 1 elements, then the last element is also automatically correct.
   }
}