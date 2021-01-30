/*
 * Rectangle class
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public class Rectangle extends XShape implements Selectable{
    // properties
    int width;
    int height;
    
    
    /*
     * Default constructor
     * @param w - widht
     * @param h - height
     * @param x - x position
     * @param y - y position
     */
    public Rectangle(int w, int h, int a, int b){
        super(a, b);
        width = w;
        height = h;
        selected = false;
    }
    
    /*
     * Method that returns the area
     * @return area
     */
    public double getArea(){
        return width * height;
    }
    
    /*
     * Method that checks whether or not the object contains points x, y
     * @param x - x position
     * @param y - y position
     * @return true if shape contains x,y points, otherwise false
     */
    public boolean contains(int a, int b){
        if( x <= a && a <= x + width && y <= b && b <= y + height){
            return true;
        }
        
        return false;
    }
    
    /*
     * String information about the class
     * @return string based information
     * @Override
     */
    public String toString(){
        return " Rectangle shape \n" + super.toString() + "\n width is : " + width + "\n height is : " + height + "\n"; 
    }
}