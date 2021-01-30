import java.util.Scanner;

/**
 * __ lab03b : Program for Planting Threes___ 
 * @author __Uður Erdem Seyfi___
 * @version __23.10.2018__
 */ 
public class Lab03b
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      //variables
      double a;
      double b;
      double c;
      
      // initial value for the flowers that we can plant to one meter square
      int flowersForMeters = 17;
      
      System.out.println( "Input the first side-length of the triangle : " );
      a = scan.nextDouble();  
      
      System.out.println( "Input the second side-length of the triangle : " );
      b = scan.nextDouble();  
      
      System.out.println( "Input the third side-length of the triangle : " );
      c = scan.nextDouble();
      
      //Check whether or not the given values form a triangle
      if( c > Math.abs(a-b) && c <= Math.abs(a+b) && b >= Math.abs(a-c) && b <= Math.abs(a+c) && a >= Math.abs(b-c) && a <= Math.abs(b+c) ){
          
          // computing the semi-perimeter and area
          double s = (a+b+c)/2;
          double area = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
          
          System.out.println( "Semi-perimeter of the triangle is: " + s);
          System.out.println( "Area of the triangle numbers is: " + area);
          
          // computing the maximum flower number that we can plant to the area
          int maximumPlantNumber = (int) (area * flowersForMeters);
          System.out.println( "The number of flowers that we can plant is: " + maximumPlantNumber );
      } else{
          System.out.println( "Can't form a triangle from the given values");
      }
      
   }
}