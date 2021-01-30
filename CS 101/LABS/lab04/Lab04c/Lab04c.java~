import java.util.Scanner;

/**
 * Lab04b: Processing Data 
 * @author Uður Erdem Seyfi
 * @version 30.10.2018
 */ 
public class Lab04b
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // 1. Declaration of variables
    
      int n; // number of imputs
      int sum; // summation of inputs
      double average; // average of the numbers
      int firstInt; // first input
      int maximum; // maximum number in the inputs
      int minimum; // minimum number in the inputs
      
      // 2. Assigning values to variables
      
      n = 100;
      sum = 0;
      
      firstInt = scan.nextInt();
      sum = sum + firstInt;
      
      maximum = firstInt;
      minimum = firstInt;
      
      // 3. calculate the summation of numbers, find the minimum number, find the maximum number
      int i = 0;
      
      while( i < (n-1) ){
          int num = scan.nextInt();
          sum = sum + num;
          
          if( num < minimum ){
              minimum = num;
          } else if (num > maximum){
              maximum = num;
          }
          
          i = i + 1;
      }
      
      // 4. calculate the average number
      average = (double) (sum / n);
      
      // 5. Output the results
      
      System.out.println(" Average of given numbers is: " + average );
      System.out.println(" Maximum number is: " + maximum );
      System.out.println(" Minimum number is: " + minimum );
   }
}