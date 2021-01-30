import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Lab06 - Some recursive methods
 * @author - Uður Erdem Seyfi
 * @date - 28.04.2019
 */

public class Lab06{
    /*
     * Testing the methods
     * @param args - arguments
     */
    public static void main(String[] args){
        System.out.println( "\n" + countNumberOfE("easdede") );
        printInBinary(16);
        ArrayList<String> letters = new ArrayList<String>();
        
        letters.add("a");
        letters.add("b");
        letters.add("c");
        
        System.out.println( "\n" + isOrdered(0, letters) );
        
        numberEnumerator(3);
    }
    
    /*
     * Method that counts occurence of 'e's in String
     * @param String
     * @return - number of e's
     */
    public static int countNumberOfE(String str){
        if( str.length() > 0){
            if( str.charAt(0) == 'e')
                return countNumberOfE( str.substring(1, str.length() ) ) + 1;
            
            return countNumberOfE( str.substring(1, str.length() ) );
        }
        
        return 0;
    }
    
    
    /*
     * Recursive method that prints a given decimalValue as binary in console
     * @param decimalValue
     */
    public static void printInBinary(int decimalValue){
        if(decimalValue != 0){
            printInBinary( decimalValue / 2);
            System.out.print( decimalValue % 2);
        }
    }
    
    /*
     * Method that checks whether or not list of strings is orderd
     * @param n - index
     * @param list - list
     * @return true if ordered, otherwise false
     */
    public static boolean isOrdered(int n, ArrayList<String> list){
        if( n >= list.size() - 1 ){
            return true;
        } else if( list.get(n).compareTo( list.get(n + 1) ) <= 0){
            return isOrdered(n + 1, list);
        } else{
            return false;
        }
    }
    
    /*
     * Method that shows all n-digit even numbers in which each digit of the number, 
     * from its most-significant to least-significant digits, is greater than the previous one.
     * @param n - digit number
     */
    public static void numberEnumerator( int n){
        numberEnumerator(1, n, "");
    }
    
    /*
     * Method that shows all n-digit even numbers in which each digit of the number, 
     * from its most-significant to least-significant digits, is greater than the previous one.
     * @param index - index for the current digit number
     * @param limit - the digit number limit that we want to reach
     * @param str - string presentation of number from the previous step
     */
    public static void numberEnumerator(int index, int limit, String str){
        
        int lastNum = str.length() != 0 ? Character.getNumericValue( str.charAt( str.length() - 1 ) ) : 0;
        
        if(index == limit){
            int s = lastNum % 2 == 0 ? lastNum + 2 : lastNum + 1;
            for(int i = s; i <= 8; i = i + 2){
                System.out.print("\n" + str + i);
            }
        } else if( index < limit){
            for(int i = lastNum + 1; i <= 9; i++){
                numberEnumerator(index + 1, limit, str+i);
            }
        }   
    }
    
}