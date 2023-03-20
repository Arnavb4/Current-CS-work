import java.lang.Math;

public class Rectangle implements Shape, Comparable<Shape>{
   
   private double s1;
   private double s2;
   
   public Rectangle(double customS1, double customS2){
      s1 = customS1;
      s2 = customS2;
   }
   
   public double getArea(){
      return s1 * s2;
   }
   public double getPerimeter(){
      return 2 * (s1 + s2);
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
      return "Rectangle with sides " + s1 + " and " + s2 + " has area " + getArea();   
   }
}