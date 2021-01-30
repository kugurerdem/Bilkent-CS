import java.util.Scanner;

/**
 * __Lab02c___ 
 * @author __U�ur Erdem Seyfi___
 * @version __16.10.2018__
 */ 
public class Lab02c
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // Getting inputs
      System.out.println( "Enter your first number: ");
      double number_1 = scan.nextInt();
      
      System.out.println( "Enter your second number: ");
      double number_2 = scan.nextInt();
      
      // Outputing the operations between number_1 and number_2
      System.out.println( "The sum of integers that are given is: " + (number_1 + number_2) );
      System.out.println( "The difference of integers that are given is: " + (number_1 - number_2) );
      System.out.println( "The product of integers that are given is: " + (number_1 * number_2) );
      System.out.println( "The division of integers that are given is: " + (number_1/number_2) );
      System.out.println( "The remainder of the given numbers division is: " + (number_1 % number_2) );
      System.out.println( "The maximum number is: " + Math.max(number_1,number_2) );
      System.out.println( "The minimum number is: " + Math.min(number_1,number_2) );
      
   }

}