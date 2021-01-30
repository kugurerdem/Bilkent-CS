import java.util.Scanner;

/*
 * Lab10b class
 * @author Uður Erdem Seyfi 
 * @version 24.12.2018
 */

public class Lab10b{
    public static void main(String[] args){

        // constants
        final int NUMBER_SIZE = 10;
        
        // variables
        
        BigNum nums[];
        BigNum num_1;
        BigNum num_2;
        BigNum biggest;
        
        // importin scanner
        
        Scanner scan = new Scanner(System.in);
        
        // assigning values to variables
        
        nums = new BigNum[NUMBER_SIZE];
        for(int i = 0; i < NUMBER_SIZE; i++){
            String num = "";
            
            for(int j = 0; j < BigNum.size; j++){
                num = num + (int) (Math.random() * BigNum.base);
            }
            
            nums[i] = new BigNum(num);
        }
        
        
        // testing isLessThan
        
        num_1 = new BigNum("6990");
        num_2 = new BigNum("9965");
        System.out.println(num_1 + " is lesser than " + num_2 + " is : " + num_1.isLessThan(num_2) );
        
        // printing the numbers
        
        System.out.print("[ ");
        for(int i = 0; i < NUMBER_SIZE; i++){
            System.out.print( i != NUMBER_SIZE - 1 ? nums[i] + ",\n" : nums[i]);
        }
        System.out.print(" ] \n");
      
        
        
        System.out.println("Enter the n value : ");
        int n = scan.nextInt();
        
        while(n > 0){            
            // finding biggest number
            biggest = new BigNum(nums[0]);
            int biggestIndex = 0;
            
            // find biggest number
            for(int i = 0; i < n; i++){
                if( biggest.isLessThan(nums[i]) ){
                    biggest = new BigNum( nums[i] );
                    biggestIndex = i;
                }
            }
            
            System.out.println("Biggest number is " + biggest);
            
            // swap the numbers
            BigNum temp = new BigNum(nums[n-1]);
            nums[n-1] = new BigNum(biggest);
            nums[biggestIndex] = temp;
            
            // printing the numbers
            
            System.out.print("[ ");
            for(int i = 0; i < NUMBER_SIZE; i++){
                System.out.println( i != NUMBER_SIZE - 1 ? nums[i] + ",\n" : nums[i]);
            }
            System.out.print(" ] \n");
            
            // get input
            System.out.println("Enter the n value : ");
            n = scan.nextInt();
        }            
   
    }
    
}