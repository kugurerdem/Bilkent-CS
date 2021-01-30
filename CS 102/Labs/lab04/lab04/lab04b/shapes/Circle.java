package shapes;

/*
 * Circle class that extends XShape and implements Selectable
 * @author Uður Erdem Seyfi
 * @version 30.03.2019
 */

public class Circle extends XShape implements Selectable{
    // properties
    int radius;
    
    /*
     * Default constructor
     * @param r - radius
     * @param a - x position
     * @param y - y position
     */
    public Circle(int r, int a, int b){
        super(a, b);
        radius = r;
    }
    
    /*
     * Method that returns area
     * @return area
     */
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
    /*
     * Method that checks whether or not the object contains points x, y
     * @param x - x position
     * @param y - y position
     * @return true if shape contains x,y points, otherwise false
     */
    public boolean contains(int a, int b){
        if( Math.sqrt( Math.pow((x - a), 2) + Math.pow((y - b), 2) ) <=radius){
            return true;
        }
        
        return false;
    }
    
    /*
     * setter method for radius property
     * @param radius
     */
    public void setRadius(int r){
        radius = r;
    }
    
    /*
     * getter method for radius property
     * @param radius
     */
    public int getRadius(){
        return radius;
    }
    
    /*
     * String information about the class
     * @return string based information
     * @Override
     */
    public String toString(){
        return " Circle shape \n" + super.toString() + "\n radius is : " + radius + "\n"; 
    }
}