import java.util.Scanner;

/**
 * Lab05d: Calculating PI with 0.1 error
 * Uður Erdem Seyfi
 * 06.11.2018
 */ 
public class Lab05d
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // Declaring variables
      double pi;
      int n; // first n terms of the series
      double error; // error ratio
      
      // Assigning values to variables
      
      System.out.println("Enter first n terms of the series and error ratio: ");
      n = scan.nextInt();
      error = scan.nextDouble();
      
      // 1. Output Math.PI by constant
      System.out.println("Math.PI = " + Math.PI);
      
      // 2. Calculating PI by first 3 terms
      pi = 0;
      
      for(int i = 0; i < n; i++){
          if( i % 2 == 0 ){
              pi = pi + (double) 4/(1 + i*2);
          } else{
              pi = pi - (double) 4/(1 + i*2);
          }
      }
      
      System.out.println("PI calculated with 3 first terms in the series is : " + pi);
      
      // 3. Calculating PI with 0.01 error
      int counter;
      
      pi = 0;
      counter = 0;
      
      while( ! (Math.abs( Math.PI - pi ) < error) ){
          
          if( counter % 2 == 0){
              pi = pi + (double) 4 / (1 + counter*2);
          } else{
              pi = pi - (double) 4 / (1 + counter*2);
          }
          counter++;
      }
      
      System.out.println("PI calculated with " + error + " error is : " + pi);
   }

}