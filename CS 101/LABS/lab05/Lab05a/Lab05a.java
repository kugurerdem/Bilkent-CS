import java.util.Scanner;

/**
 * Creating Rectangles 
 * Uður Erdem Seyfi
 * 06.11.2018
 */ 
public class Lab05a
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // 1. Declaring variables
      
      int width, height, thickness;
      String column, row, hole, cont;
      
      // Do the things
     
          
      // Getting inputs from the user
      System.out.print("Enter width, height & thickness: ");
          
      width = scan.nextInt(); 
      height = scan.nextInt();
      thickness = scan.nextInt();
      
      // Program code
      do{
          
          if( !(width > 0 && height > 0 && thickness > 0) ){
              System.out.print("Error: All values must be positive!");
          } else{
              for(int i = 1; i <= height; i++){
                  
                  if( i <= thickness || i > height - thickness ){
                      
                      for(int j = 1; j <= width; j++){
                          System.out.print("*");
                      }                      
                  } else{
                      
                      for(int j = 1; j <= width; j++){
                          
                          if( j <= thickness || j > width - thickness ){
                              System.out.print("*");
                          } else{
                              System.out.print(" ");
                          } 
                      }
                  }
                  System.out.println();
              }
              
              // If there is no hole print out no hole
              if( height - 2*thickness <= 0 ){
                  System.out.println("No hole! ");
              }
              
          }
          
          System.out.println("Do you want to create another pattern? Y/y");
          cont = scan.next();
          
      } while( cont.equals("y") || cont.equals("Y") );
      
   }
}