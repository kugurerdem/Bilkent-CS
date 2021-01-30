import java.util.Scanner;

/**
 * Lab04d: Tree of Chars 
 * @author Uður Erdem Seyfi
 * @version 30.10.2018
 */ 
public class Lab04d
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // 1. Declaring variables
      
      char ch;
      int width;
      
      // 2. Assigning values to variables
      
      System.out.println("char :");
      ch = scan.next().charAt(0);
      
      System.out.println("width :");
      width = scan.nextInt();

      // 3. Program code
      
      int i = 1;
      while(i <= width){
          int j = 0;
          
          String str = "";
          while(j < i){
              str = str + ch;
              j = j+1;
          }
          
          System.out.print(str + "\n");
          i = i+1;
      }
      
      /*
       double d;
       d = 0.1;
       while ( ! ( Math.abs( d - 1 ) < 0.01 ) )
       {
       System.out.println( d);
       d = d + 0.1;
       }
       System.out.println( d + " <- final value after loop!");
      */
      
   }

}