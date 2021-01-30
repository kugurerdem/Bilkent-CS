package shapes;

/*
 * Abstract class that extends Shape
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public abstract class XShape extends Shape {
    // properties
    boolean selected;
    
    /*
     * Default constructor
     * @param x - x position
     * @param y - y position
     */
    public XShape(int a, int b){
        super(a, b);
        selected = false;
    }
    
    /*
     * Toggles selected to the given boolean
     * @param s - boolean
     */
    public void setSelected(boolean s){
        selected = s;
    }
    
    /*
     * Method that returns selected 
     * @return selected
     */
    public boolean getSelected(){
        return selected;
    }
    
    /*
     * String information about the class
     * @return string based information
     */
    public String toString(){
        String str = selected ? " this object is selected " : " this object is not selected ";
        str = str + super.toString();
        return str;
    }
}