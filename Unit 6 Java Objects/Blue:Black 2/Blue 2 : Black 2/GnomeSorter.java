import java.util.Arrays;

public class GnomeSorter extends MeasureSorter {
   public GnomeSorter(String filename) throws Exception {
      super(filename);
   }
   public void gnomeSorting(){
      int index = 0;
      while (index < measures.length) {
         if (index == 0){
            index++;
         }
         if (measures[index].compareTo(measures[index - 1]) >= 0){
            index++;
         }
         else{
            swap(index, index - 1);
            index--;
         }
      }
      System.out.println(Arrays.toString(measures));
        return;
   }
   public void sortMe(){
      gnomeSorting();
   }
}