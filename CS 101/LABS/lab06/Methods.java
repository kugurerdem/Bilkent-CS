import java.util.Scanner;


public class Methods
{
    // Function that takes n and k, and gives n^k
    public static double power(double n, int k){
        double result;
        
        result = 1;
        for(int i = 0; i < k; i++){
            result = result * n;
        }
        
        return result;
    }
    
    // Function that takes n and gives n!
    public static int factorial(int n){
        int result;
        
        result = 1;
        for(int i = 2; i <= n; i++){
            result = result * i;
        }
        
        return result;
    }
    
    // Function that reverses a given string
    public static String reverse(String str){
        String result;
        
        result = "";
        for(int i = 0; i < str.length(); i++){
            result = str.charAt(i) + result;   
        }
        
        return result;
    }
    
    // Function that reverses text 
    public static String reverseWords(String text){
        String result;
        String word; 
        
        result = "";
        word = "";
    
        for(int i = 0; i < text.length(); i++){
            if( text.charAt(i) == ' '){
                result = result + ' ' + word;
                word = "";
            } else{
                word = text.charAt(i) + word;
            }
        }
        
        result = result + ' ' + word;
        
        return result;
        
    }
    
    // Binary to decimal converter
    public static int toDecimal(String base2){
        int result;
        int len;
        
        len = base2.length();
        result = 0;
        
        for(int i = len - 1; i >= 0; i--){
            int index_num;
            int pow; 
            
            result = result + ( Character.getNumericValue(base2.charAt(i)) * (int)power(2, len - 1 - i) );
        }
        
        return result;
    }
    
    // Decimal to binary
    public static String toBinary(int num){
        int decimal;
        String binaryString;
        
        decimal = num;
        binaryString = "";
        
        do{ 
            if(decimal % 2 == 0){
                binaryString = "0" + binaryString;
            } else{
                binaryString = "1" + binaryString;
            }
            decimal = decimal / 2;
        }while(decimal != 0);
        
        
        return binaryString;
    }
    
    // Taylor sin(x) for the first n terms.
    
    public static double sin(double x, int n){
        double result;
        double element;
        
        element = power(x, 1); 
        result = element;
        
        for(int i = 1; i <= n; i++){
            element = -1 * element * power(x, 2) / ( (2*i + 1) * (2*i) );
            result = result + element;
        }
        
        return result;
    }

}