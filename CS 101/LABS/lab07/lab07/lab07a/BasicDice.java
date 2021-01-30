/*
 * BasicDice
 * @author Uður Erdem Seyfi
 * @version 04.12.2018
 */

public class BasicDice{
    
    public static void main(String[] args){
        
        for(int i = 0; i < 10; i ++){
            // declare variables
            int count;
            int dice_1;
            int dice_2;
            
            // set count's initial value to 0 at first
            count = 0;
            // count and roll until you get 6-6
            do{
                dice_1 = 1 + (int)(Math.random() * 6);
                dice_2 = 1 + (int)(Math.random() * 6);
                count = count + 1;
            }while(dice_1 + dice_2 != 12);
            
            // print out the count number
            System.out.println(" " + (i+1) + " throwed 12 after " + count + " trials "); 
        }
        
    }
    
    
}