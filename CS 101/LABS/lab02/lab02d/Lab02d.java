import java.util.Scanner;

/**
 * __ lab04d : Program for Planting Threes___ 
 * @author __Uður Erdem Seyfi___
 * @version __16.10.2018__
 */ 
public class Lab02d
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // initial value for the flowers that we can plant to one meter square
      int flowersForMeters = 17;
      
      System.out.println( "Input the first side-length of the triangle : " );
      double a = scan.nextDouble();  
      
      System.out.println( "Input the second side-length of the triangle : " );
      double b = scan.nextDouble();  
      
      System.out.println( "Input the third side-length of the triangle : " );
      double c = scan.nextDouble();
      
      // computing the semi-perimeter and area
      double s = (a+b+c)/2;
      double area = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
      
      System.out.println( "Semi-perimeter of the triangle is: " + s);
      System.out.println( "Area of the triangle numbers is: " + area);
      
      // computing the maximum flower number that we can plant to the area
      int maximumPlantNumber = (int) area * flowersForMeters;
      System.out.println( "The number of flowers that we can plant is: " + maximumPlantNumber );
      
   }

}