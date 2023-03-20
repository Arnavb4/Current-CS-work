import java.lang.Math;

public class Circle implements Shape, Comparable<Shape>{
   
   private double r1;
   
   public Circle(double customR1){
      r1 = customR1;
   }
   
   public double getArea(){
      return Math.pow(r1, 2) * Math.PI;
   }
   public double getPerimeter(){
      return 2 * r1 * Math.PI;
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
      return "Circle with radius " + r1 + " has area " + getArea(); 
   }
}