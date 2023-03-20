import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class ShapesReader{

   private Shape[] shapes;
   
   public ShapesReader(String filename) throws Exception{
      Scanner infile = new Scanner(new File(filename));
      int numItems = Integer.parseInt(infile.nextLine());
      shapes = new Shape[numItems];
   
      for(int i = 0; i < numItems; i++){
         String [] temp = infile.nextLine().strip().split(" ");
         if (temp[0].equals("Triangle")){
            double s1 = Double.parseDouble(temp[1]);
            double s2 = Double.parseDouble(temp[2]);
            double s3 = Double.parseDouble(temp[3]);
            shapes [i] = new Triangle(s1, s2, s3);
         }
         else if (temp[0].equals("Square")){
            double s1 = Double.parseDouble(temp[1]);
            shapes [i] = new Square(s1);
         }
         else if (temp[0].equals("Circle")){
            double r1 = Double.parseDouble(temp[1]);
            shapes [i] = new Circle(r1);
         }
         else if (temp[0].equals("Parallelogram")){
            double base = Double.parseDouble(temp[1]);
            double slantHeight = Double.parseDouble(temp[2]);
            double verticalHeight = Double.parseDouble(temp[3]);
            shapes [i] = new Parallelogram(base, slantHeight, verticalHeight);
         }
         else if (temp[0].equals("Rectangle")){
            double l1 = Double.parseDouble(temp[1]);
            double l2 = Double.parseDouble(temp[2]);
            shapes [i] = new Rectangle(l1, l2);
         }
      }
   }
   
   public String toString(){
      return Arrays.toString(shapes);   
   }
   
   public void sortMe(){
      Arrays.sort(shapes);
   }
}