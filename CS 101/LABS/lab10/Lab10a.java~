/*
 * Lab10a class
 * @author Uður Erdem Seyfi 
 * @version 24.12.2018
 */

public class Lab10a{
    
    public static void main(String[] args){
        
        // variables
        
        BigNum num_1;
        BigNum num_2;
        BigNum num_3;
        BigNum num_4;
        BigNum num_5;
        
        int overflow;
        
        // assigning values to variables
        
        num_1 = new BigNum();
        num_2 = new BigNum("123");
        num_3 = new BigNum(num_2);
        num_4 = new BigNum("4560");
        num_5 = new BigNum("9512");
        
        // numbers
        
        System.out.println("num_1 : " + num_1);        
        System.out.println("num_2 : " + num_2);
        System.out.println("num_3 : " + num_3);
        System.out.println("num_4 : " + num_4);
        System.out.println("num_5 : " + num_5);
        
        // testing shift
        
        System.out.print(num_3 + " shifted to left is ");
        num_3.shift(true);
        System.out.println(num_3);
        
        
        // testing add
        
        System.out.print(num_3 + " added with " + num_4 + " is ");
        overflow = num_3.add(num_4);
        System.out.println(num_3 + " with overflow " + overflow);
        
        // overflow
        
        System.out.print(num_4 + " added with " + num_5 + " is ");
        overflow = num_4.add(num_5);
        System.out.println(num_4 + " with overflow " + overflow);
        
    }
}