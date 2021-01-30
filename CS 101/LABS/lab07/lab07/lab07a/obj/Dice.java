package obj;

/*
 * Dice
 * @author U�ur Erdem Seyfi
 * @version 04.12.2018
 */

public class Dice{
    // properties
    private Die die_1;
    private Die die_2;
    
    /*
     * Constructor for Dice class
     */
    public Dice(){
        die_1 = new Die();
        die_2 = new Die();
    }
    
    /*
     * Method that rolls the dice
     */
    public void roll(){
        die_1.roll();
        die_2.roll();
    }
    
    /*
     * Function that returns die_1 face value
     * @return die_1 face value
     */
    public int getDie1FaceValue(){
        return die_1.getFaceValue();
    }
    
    /*
     * Function that returns die_2 face value
     * @return die_2 face value
     */
    public int getDie2FaceValue(){
        return die_2.getFaceValue();
    }
    
    /*
     * Function that returns total face value
     * @return die_2 face value + die_1 face value
     */
    public int getDiceTotal(){
        return getDie1FaceValue() + getDie2FaceValue();
    }
    
    /*
     * Method that returns string information about the dice
     * @return string information
     */
    public String toString() { 
        return "Die 1 face: " + getDie1FaceValue() + "\n Die 2 face: " + getDie2FaceValue() + "\n Total dice : " + getDiceTotal();
    } 
    
    
    
}