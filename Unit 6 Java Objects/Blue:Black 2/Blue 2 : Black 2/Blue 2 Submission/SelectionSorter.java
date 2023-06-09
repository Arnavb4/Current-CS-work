import java.util.Arrays;

public class SelectionSorter extends MeasureSorter
{
   public SelectionSorter(String filename) throws Exception
   {
      super(filename);
   }
   
   public int findMinIndex(int startingIndex)  //Write and test this first!
   {
      int minIndex = startingIndex;
      for (int i = startingIndex; i < measures.length; i++){
         if (measures[i].compareTo(measures[minIndex]) == -1){
            minIndex = i;
         }
      }
      return minIndex;
   }
   
   public void sortMe()  //For SelectionSorter to compile, this class needs to implement the abstract method sortMe() in MeasureSorter.  Right now the implementation is empty, but it will compile!  This allows you to test findMinIndex separately.
   {
      for (int i = 0; i < measures.length; i++){
         System.out.println(Arrays.toString(measures));
         swap(i, findMinIndex(i));
      }
   }
}