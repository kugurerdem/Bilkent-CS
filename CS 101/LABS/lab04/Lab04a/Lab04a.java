import java.util.Scanner;

/**
 * Lab04a: While Loop Excercises 
 * @author U�ur Erdem
 * @version 30.10.2018
 */ 

public class Lab04a{
    public static void main(String[] args){
        
        Scanner scan = new Scanner( System.in);
        
        // variables
        int n;
        int i;
        
        System.out.println("Enter a number: ");
        n = scan.nextInt();
        
        if( n <= 0 ){
            // If the number is not positive give an error message
            System.out.print("Error! The number that you given is not a positive number.");
        } else{
            
            // Otherwise do the computations
            
            // 1. Integer values from 0 up to n exclusive in a single line.
            System.out.print("Integer values from 0 up to n:  \n \n");
            
            i = 0;
            
            while( i < n ){
                System.out.print(i + " ");
                i = i + 1;
            }
            
            System.out.print( "\n \n" );
            
            // 2. Integer values from 0 up to n exclusive in seperated lines with 5 elements.
            System.out.print("Integer values from 0 up to n (in seperated lines):  \n \n");
            
            i = 0;
            
            while( i < n ){
                System.out.print(i + " ");
                i = i + 1; 
                
                if( i % 5 == 0){
                    System.out.print( "\n" );
                }
            }
            
            System.out.print( "\n \n" );
            
            // 3. Integer values from n down to 0 inclusive in a single line.
            System.out.print( "Integer values from n down to 0 \n \n" );
            i = n;
            
            while( i >= 0 ){
                System.out.print(i + " ");
                i = i - 1;
            }
            System.out.print( "\n \n" );
            
            // 4. Integer values from n down to -n inclusive in a single line.
            
            System.out.print( "Integer values from n down to -n: \n \n" );
            
            i = n;
            
            while( i >= -n ){
                if( i % 2 == 0){
                    System.out.print(i + " ");
                }
                i = i - 1;
            }
            
            System.out.print( "\n \n" );
            
            // 5. Squares of the even values from 0 up to n inclusive (separated by spaces, five numbers per line)
            
            System.out.print( "Squares of the even values from 0 up to n inclusive: \n \n" );
            
            i = 0;
            
            while( i <= n ){
                
                System.out.print( (i*i) + " ");
                i = i + 2;
                
                if( (i/2) % 5 == 0 ){
                    System.out.print( "\n" );
                }   
            }
            
            System.out.print( "\n \n" );
            
            // 6. The values which are divisible by 3 or 4, but not both, from n down to 3 inclusive (separated by spaces, five numbers per line)
            int count;
            
            System.out.print( "The values which are divisible by 3 or 4, but not both, from n down to 3: \n \n" );
            
            i = n;
            count = 0;
            
            while( i >= 3 ){
                
                if( ( (i % 3 == 0) && (i % 4 != 0) ) || (i % 3 != 0) && (i % 4 == 0) ){
                    System.out.print(i + " ");
                    count = count + 1;
                    
                    if( count % 5 == 0 ){
                        System.out.print( "\n" );
                    }  
                }
                
                i = i - 1; 
            }
            
            System.out.print( "\n \n" );
            
            // 7. All of the divisors of n in a single line
            
            System.out.print( "All divisors of n: \n \n" );
            i = 1;
            
            while( i <= n ){
                if( n % i == 0 ){
                    System.out.print( i + " " );
                }
                
                i = i + 1;
            }
            
            System.out.print( "\n \n" );
            
            // 8. Values of 1 / k (with two significant figures) for every integer k from n down to 1
            
            System.out.print( "alues of 1 / k for every integer k from n down to 1 \n \n" );
            
            i = n;
            
            while( i >= 1 ){
                double num = 1.0 / (float) i;
                
                if ( num > 0.01 ){
                    String temp = String.format("%.2f", num);
                    System.out.print( temp + " ");
                }
                
                i = i - 1;
            }
        }    
        
    }
}