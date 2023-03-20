import java.lang.Math;

public class Triangle implements Shape, Comparable<Shape>{
   
   private double s1;
   private double s2;
   private double s3;
   
   public Triangle(double customS1, double customS2, double customS3){
      s1 = customS1;
      s2 = customS2;
      s3 = customS3;
   }
      
   public double getArea(){
      double semiPer = getPerimeter() / 2;
      return Math.sqrt(semiPer * (semiPer - s1) * (semiPer - s2) * (semiPer - s3));
   }
   public double getPerimeter(){
      return s1 + s2 + s3;
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
      return "Triangle with sides " + s1 + " " + s2 + " and " + s3 + " has area " + getArea();
   }
}