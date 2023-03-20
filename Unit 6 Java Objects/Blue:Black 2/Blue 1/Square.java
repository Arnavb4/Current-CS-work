import java.lang.Math;

public class Square implements Shape, Comparable<Shape>{
   
   private double s1;
   
   public Square(double customS1){
      s1 = customS1;
   }
   
   public double getArea(){
      return Math.pow(s1, 2);
   }
   public double getPerimeter(){
      return s1 * 4;
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
      return "Square with side " + s1 + " has area " + getArea();   
   }
}