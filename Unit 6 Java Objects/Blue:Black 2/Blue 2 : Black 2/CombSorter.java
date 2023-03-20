import java.util.Arrays;

public class CombSorter extends MeasureSorter{
   
   public CombSorter(String filename) throws Exception
   {
      super(filename);
   }
   
   public int getNextGap(int gap){
      gap = (gap * 10)/13;
      if (gap < 1){
         return 1;
      }
      return gap;
   }
   
   public void combing(){
      int gap = measures.length;
      boolean swapped = true;
      while(gap != 1 && swapped){
         gap = getNextGap(gap);
         swapped = false;
         for (int i = 0; i < measures.length - gap; i++){
            if (measures[i].compareTo(measures[i + gap]) > 0){
               swap(i, i + gap);
            }
            swapped = true;
            //System.out.println(Arrays.toString(measures));
         }
      }
      
   }
   
   public void sortMe(){
      int N = measures.length;
      for(int i = 0; i < N - 1; i++) //N - 1 again! Each bubble pass is guaranteed to place one more element correctly, but if 
      {                              //I correctly place N - 1 elements, then the last element is also automatically correct.
         System.out.println(Arrays.toString(measures));
         combing();
      }
   }
}