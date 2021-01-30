/*
 * Selectable interface
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public interface Selectable{    
    boolean getSelected(); // returns a boolean selected's value 
    void setSelected( boolean s); // sets boolean selected's value to s
    boolean contains( int x, int y); // checks whether or not the object contains points x, y
}