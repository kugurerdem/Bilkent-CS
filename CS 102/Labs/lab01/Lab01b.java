import java.util.Scanner;

/*
 * Lab01b
 * @author Uður Erdem Seyfi
 * @version 18.02.2019
 */

public class Lab01b{
    
    /*
     * main method which executes the program
     * @param args - arguments
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        // variables
        IntBag primes;
        int num;
        int givenIndex;
        
        // assign values to variables
        primes = new IntBag();
        primes.add(2);
        
        num = 3;
        
        System.out.println(" Give index : ");
        givenIndex = scan.nextInt();
        
        // keep searching new primes until you found 100 primes
        while(primes.size() <= 100){
            boolean isDivisible = false;
            
            // check whether or not is there a prime that can divide num
            for(int i = 0; i < primes.size(); i++){
                if(num % primes.get(i) == 0){
                    isDivisible = true;
                    break;
                }
            }
            
            // if it is not divisable by other primes then it is prime
            if(!isDivisible){
                primes.add(num);
            }
            
            // increase nums value by 2 because even numbers can't be prime (except 2)
            num = num + 2;
        }
        
        // print the prime numbers
        System.out.println(primes);
        System.out.println("Prime number at given index " + givenIndex + " is " + primes.get(givenIndex) );
    } 
}