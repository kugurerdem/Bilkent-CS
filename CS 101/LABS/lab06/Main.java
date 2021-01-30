import java.util.Scanner;

/**
 * Lab06: Using Methods 
 * Uður Erdem Seyfi
 * 13.11.2018
 */ 
public class Main
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // 1. Print a table with columns n, n-squared, n-cubed & n to the power 4, for values of n from -1 to 10 inclusive
      // TableOfPower(min, max, max_power)
      
      System.out.println("\nTable of Powers: \n");
      Print.TableOfPowers(-1, 10, 4); 
      
      // 2. Print a table of n and n-factorial, for values of n from 1 to 15
      // TableOfFactorials(min, max, cell_num)

      System.out.println("\nTable of factorials : \n");
      Print.TableOfFactorials(1,15,5);
      
      // 3. Read two binary (base-2) Strings from the user, convert them to decimal, then add them together and print the result in binary form.
      int decimal_1, decimal_2;
      String binary_1, binary_2;
      
      System.out.println("Enter two binary numbers");
      
      // Get the binary values from the user.
      binary_1 = scan.next();
      binary_2 = scan.next();
      
      // Convert them to decimals
      decimal_1 = Methods.toDecimal(binary_1);
      decimal_2 = Methods.toDecimal(binary_2);
      
      System.out.println("decimal_1 " + decimal_1);
      System.out.println("decimal_2 " + decimal_2);
      System.out.println("The summation of these two binary numbers is : " + Methods.toBinary( decimal_1 + decimal_2 ) );
      
      // 4. Reverse the users text.
      String text;
      
      System.out.println("Enter a text : ");
      
      scan.nextLine();
      text = scan.nextLine();
      
      System.out.println("Words in the text is reversed, so new text is : \n " + Methods.reverseWords(text) );
      
      // 5. Compare the Math.sin(x) with your own method
      double radian, degree;
      
      System.out.println("Enter a degree: ");
      degree = scan.nextDouble();
      radian = (degree / 180) * Math.PI;
      Print.TableOfSin(radian, 10);
      
      
      System.out.println( "sin(x) calculated by Taylor series : " + Methods.sin(radian, 5) );
      System.out.println( "sin(x) calculated by Math.sin(x) : " + Math.sin(radian) );
      
   }

}