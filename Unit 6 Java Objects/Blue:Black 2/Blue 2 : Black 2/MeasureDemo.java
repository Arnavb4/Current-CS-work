public class MeasureDemo
{
   public static void main(String[] args) throws Exception
   {
      
      //System.out.println("Bubble Sort:");
      //BubbleSorter bub = new BubbleSorter("measures_10.txt");
      //bub.sortMe();
      //System.out.println();
      
      
      //Second: selection sort.  Uncomment the first block of code to test findMinIndex, then when that's working complete the selection 
      //sort algorithm and uncomment the next block of code to test that.
      
      /*
      SelectionSorter sel = new SelectionSorter("measures_30.txt"); 
      for(int i = 0; i < sel.measures.length; i++)  
      {
         System.out.println("The Measure at index " + i + " is: " + sel.measures[i]);  
      }
      int startIndex = 0;  
      int mI = sel.findMinIndex(startIndex);
      System.out.println("Your method says that the minimum value from index " + startIndex + " to the end of the array is at index " + mI +".  Make sure that's correct by looking at the output above!");
      */
      
      /*
      System.out.println("Selection Sort:");
      SelectionSorter sel = new SelectionSorter("measures_10.txt");
      sel.sortMe();
      System.out.println();
      */
      
      
      //Third: insertion sort.  This one is up to you!  Feel free to add code to this demo to test something if you need to!
      
      
      //System.out.println("Insertion Sort:");
      //InsertionSorter in = new InsertionSorter("measures_10.txt");
      //in.sortMe();
      //System.out.println();
      
      System.out.println("Comb Sort:");
      CombSorter bub = new CombSorter("measures_10.txt");
      bub.sortMe();
      System.out.println();
      
   }
}