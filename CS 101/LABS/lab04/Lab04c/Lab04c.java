import java.util.Scanner;

/**
 * Lab04c: Processing Data... 
 * @author Uğur Erdem Seyfi
 * @version 30.10.2018
 */ 
public class Lab04c
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // 1. Declaration of variables
    
      int sum; // summation of inputs
      double average; // average of the numbers
      int num; //  
      int maximum; // maximum number in the inputs
      int minimum; // minimum number in the inputs
      int count; // count of numbers so far
      boolean firstNegativeFound = false;
      
      // 2. Assigning values to variables
      sum = 0;
      
      num = scan.nextInt();
      sum = sum + num;
      
      maximum = num;
      minimum = num;
      
      // 3. calculate the summation of numbers, find the minimum number, find the maximum number
      
      count = 1;
      
      while( num >= 0 ){
          count = count + 1;
          sum = sum + num;
          
          if( num < minimum ){
              minimum = num;
          } else if (num > maximum){
              maximum = num;
          }
          
          num = scan.nextInt();
      }
      
      // 4. calculate the average number
      average = (double) (sum / count);
      
      // 5. Output the results
      
      System.out.println(" Average of given numbers is: " + average );
      System.out.println(" Maximum number is: " + maximum );
      System.out.println(" Minimum number is: " + minimum );
   }
}