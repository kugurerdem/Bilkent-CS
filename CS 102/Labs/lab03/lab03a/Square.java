/*
 * Square class that extends Rectangle
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public class Square extends Rectangle{
    // properties
    int side;
    
    /*
     * Default constructor
     * @param s - side
     * @param a - x position
     * @param b - y position
     */
    public Square(int s, int a, int b){
        super(s, s, a, b);
    }
    
}