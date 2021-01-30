import obj.*;
import java.util.ArrayList;

/*
 * Histogram Program
 * @author Uður Erdem Seyfi
 * @version 18.12.2018
 */

public class Histogram{
    
    public static void main(String[] args){
        // Constants
        final int ROLL_NUMBER;
        
        // Variables
        ArrayList<Integer> rollCounts;
        Dice dice = new Dice();
        
        
        // Assigning values to variables
        ROLL_NUMBER = 10;
        rollCounts =  new ArrayList<Integer>();
        
        // Initializing frequencies with 0
        for(int i = 0; i < 11; i++){
            rollCounts.add(0);
        }
        
        // Rolling dices for ROLL_NUMBER times
        for(int i = 0; i < ROLL_NUMBER; i++){
            dice.roll();
            int val = dice.getDiceTotal();
            rollCounts.set( val-2, rollCounts.get(val-2) + 1 ); 
        }
        
        System.out.println("max frequency is : " + frequencyData(rollCounts));
        System.out.println(rollCounts);
        drawHistogram( rollCounts );
        
    }
    
    /*
     * Function that draws histogram
     * @param arr - takes array
     */
    public static void drawHistogram(ArrayList arr){
        int maxFrequency = frequencyData(arr);
        double rowNum = 10;
        double starValue = maxFrequency / rowNum;
        
        String result = ""; 
        
        for(int i = 0; i < rowNum; i++){
            
            for(int j = arr.size()-1; j >= 0; j--){
                if( (double) (i+1) * starValue < (int) arr.get(j) ){
                    result =  " * " + result;
                }else{
                    result = "   " + result;
                }
            }
            
            result = "\n" + result;
        }
        
        System.out.println(result);
    }
    
    
    /*
     * Function that returns the max frequency
     * @param arr - takes array
     * @return - max frequency in the array
     */
    public static int frequencyData(ArrayList arr){
        int maxFrequency = (int) arr.get(0);
        
        for(int i = 1; i < arr.size(); i++){
            int val = (int) arr.get(i);
            if( val > maxFrequency ){
                maxFrequency = val;
            }
        }
        
        return maxFrequency;
    }
    
    
    
}