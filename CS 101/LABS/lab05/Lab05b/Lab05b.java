import java.util.Scanner;

/**
 * Lab05b: Rows and Columns
 * Uður Erdem Seyfi
 * 06.11.2018
 */ 
public class Lab05b
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // Declaring variables
      
      int row, col, space, space_multiplication;
      
      // Assigning values to variables
      
      row = scan.nextInt();
      col = scan.nextInt();
      
      space = (""+row+","+col).length() + 2;
      space_multiplication = ("" + (row * col)).length() + 2;
      
      // 1. Row & column numbbers
      
      System.out.println("\nRow & column numbers: \n");
      
      for(int i = 1; i <= row; i++){
          
          String line = "";
          
          for(int j = 1; j <= col; j++){
              line = line + i + "," + j;
              
              int len = line.length();
              
              for(int l = 0; l < space - len%space; l++){
                  line = line + " ";
              }
          }
          
          System.out.println(line);
      }
      
      // 2. A multiplication table
      
      System.out.println("\nMultiplication table: \n");
      
      for(int i = 1; i <= row; i++){
          
          String line = "";
          
          for(int j = 1; j <= col; j++){
              line = line + (i*j);
              int len = line.length();
              
              for(int l = 0; l < space - len%space; l++){
                  line = line + " ";
              }
          }
          System.out.println(line);
      }
      
      // 3. The cell number beginning from 0 and increasing left to right, top to bottom 
      
      System.out.println("\nThe cell numbers: \n");
      
      for(int i = 1; i <= row; i++){
          
          String line = "";
          
          for(int j = 1; j <= col; j++){
              line = line + ((i-1)*col + j) + ((j != col) ? "," : "");
              
              int len = line.length();
              
              for(int l = 0; l < space_multiplication - len%space_multiplication; l++){
                  line = line + " ";
              }
          }
          System.out.println(line);
      }
      
      // 4. The row number in the first column only, putting the String "-" into the other cells.
      
      System.out.println("\n The first column num, other columns: \n");
      
      for(int i = 1; i <= row; i++){
          
          String line = "";
          
          line = line + i;
          for(int j = 1; j <= col-1; j++){
              
              int len = line.length();
              for(int l = 0; l < space - len%space; l++){
                  line = line + " ";
              }
              
              line = line + "-";
          }
          System.out.println(line);
      }
      
   }

}