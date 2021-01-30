package shapes;

/*
 * Abstract class for creating shapes
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public abstract class Shape implements Locatable{
    // properties
    int x;
    int y;
    
    /*
     * Default constructor that takes two parameters
     * @int x - horizontal pos
     * @int y - vertical pos
     */
    public Shape(int a, int b){
        x = a;
        y = b;
    }
    
    // normal methods
    
    /*
     * Method that sets location the the given points
     * @param x - takes x position
     * @param y - takes y position
     */
    public void setLocations(int a, int b){
        x = a;
        y = b;
    }
    
    /*
     * method that returns y position
     * @return - x position
     */
    public int getX(){
        return x;
    }
    
    /*
     * method that returns y position
     * @return - y position
     */
    public int getY(){
        return y;
    }
    
    /*
     * String information about the class
     * @return string based information
     */
    public String toString(){
        return "\n x, y position: (" + x + "," + y + ")";
        
    }
    
    // abstract methods
    abstract double getArea();
    
    
}