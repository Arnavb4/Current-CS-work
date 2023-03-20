import java.lang.Math;

public class Parallelogram implements Shape, Comparable<Shape>{
   
   private double base;
   private double slantHeight;
   private double verticalHeight;
   
   public Parallelogram(double customBase, double customSlantHeight, double customVerticalHeight){
      base = customBase;
      slantHeight = customSlantHeight;
      verticalHeight = customVerticalHeight;
   }
   
   public double getArea(){
      return base * verticalHeight;
   }
   public double getPerimeter(){
      return 2 * (slantHeight + base);
   }
   
   public int compareTo(Shape x){
      if (getArea() > x.getArea()){
         return 1;
      }
      else if (getArea() == x.getArea()){
         return 0;
      }
      else{
         return -1;
      }
   }
   
   public String toString(){
      return "Parallelogram with base " + base + " slant height " + slantHeight + " and height " + verticalHeight + " has area " + getArea();   
   }
}