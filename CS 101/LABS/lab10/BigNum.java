/*
 * BigNum class
 * @author Uður Erdem Seyfi 
 * @version 24.12.2018
 */

public class BigNum{
    
    // constants
    final static int size = 8;
    final static int base = 7;
    
    // properties
    int[] data;
    
    /*
     * Default constructor
     */
    public BigNum(){
        
        data = new int[size];
        for(int el : data){
            el = 0;
        }
    }
    
    /*
     * String Constructor
     * @param string - String number
     */
    public BigNum(String num){
        
        this();
        for(int i = 0; i < num.length() ; i++){
            data[num.length()  - 1 - i] = Character.getNumericValue( num.charAt(i) ); 
        }
    }
    
    /*
     * Copy Constructor
     * @param num - BigNum
     */
    public BigNum(BigNum num){
        data = num.data;
    }
    
    /*
     * Function that shifts data
     * @param left - shifts left if true, right if false
     */
    public void shift(boolean left){
        int[] new_arr = new int[size];
        
        if(left){
            
            for(int i = new_arr.length - 1; i > 0; i--){
                new_arr[i] = data[i-1];
            }
            
            new_arr[0] = 0;
            
        } else{
            
            for(int i = 0; i < new_arr.length - 1; i++){
                new_arr[i] = data[i+1];
            }
            
            new_arr[new_arr.length - 1] = 0;
        }
        
        data = new_arr;
    }
    
    /*
     * function that adds another BigNum
     * @param BigNum - other number to be added
     * @return onHand - overflow
     */
    public int add(BigNum other){
        int index = 0;
        
        while(index < size){
            data[index] = data[index] + other.data[index];
            index++;
        }
        
        int onHand = 0;
        for(int i = 0; i < data.length; i++){
            data[i] = onHand + data[i];
            onHand = data[i] / base;
            data[i] = data[i] % base;
        }
        
        return onHand;     
    }
    
    /*
     * Function that compares two bignumber
     * @param BigNum - the number to be compared
     * @return lessThan - returns if it is less then or not
     */
    
    public boolean isLessThan(BigNum other){
        boolean lessThan = false;
        int index = size - 1;
        
        while(index >= 0){
            if( other.data[index] > this.data[index]){
                return true;
            } else if( other.data[index] < this.data[index]){
                return false;
            }
            
            index = index - 1;
        }
        
        return lessThan;
    }
    
    
    /*
     * String information
     * @return str - string information about class
     */
    public String toString(){
        String str;
        
        str = "";
        for(int i = 0; i < data.length; i++){
            str = str + data[i];
        }
        
        return str;
    }
    
    
    
}