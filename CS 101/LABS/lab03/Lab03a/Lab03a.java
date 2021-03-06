import java.util.Scanner;

/**
 * __Lab03a Assignment___ 
 * @author __U�ur Erdem Seyfi___
 * @version __23.10.2018__
 */ 
public class Lab03a
{
   public static void main( String[] args)
   {
      // variables
      int oddNumbers;
      int evenNumbers;
 
      oddNumbers = 0;
      evenNumbers = 0;
      
      Scanner scan = new Scanner( System.in);

      for ( int x = 0; x <= 50; x++ ) 
      {
          // 1. Printing if x is in the range of 12-25 or not
          if( x < 12 || x > 25 ){
              System.out.println("out of range 12-25");
          }  
          
          // 2. counting oddNumbers and evenNumbers
          if( x % 2 == 0 ){
              evenNumbers = evenNumbers + 1;
          } else {
              oddNumbers = oddNumbers + 1;
          }
          
          // 3. Printing if x can be divided by some numbers or not.
          if( x % 5 == 0){
              System.out.println("Hi Five");
          } else if ( x % 7 == 0 || x % 3 == 0 ){
              System.out.println("Hi ThreeOrSeven");
          } else if( x % 2 == 0){
              System.out.println("Hi Two");
          } else {
              System.out.println("Hi Others!");
          }
      }
      
      System.out.println( "Count of odd numbers are :" + oddNumbers );
      System.out.println( "Count of even numbers are :" + evenNumbers );
      
      // Getting the n value from the user
      System.out.println( "Count numbers 1 to n, which n value do you want?" );
      
      // variables
      int n;
      int sum;
      
      // determining values of n and sum
      n = scan.nextInt();
      sum = 0;
      
      // counting 1+2+3+....+ n
      for (int i = 0; i <= n; i++){
          sum = sum + i;
      }
      
      // Checking whether our count is correct or not
      if( sum == n*(n+1)/2 ){
          System.out.println("Your sum and the n*(n+1)/2 formula result the same value");
          System.out.println("The result is: " + sum ); 
      } else{
          System.out.println("Your sum and the n*(n+1)/2 is doesn't not result the same");
      }
   }
}