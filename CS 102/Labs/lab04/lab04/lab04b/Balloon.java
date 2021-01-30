import shapes.*;
import java.awt.*;

/*
 * Balloon class
 * @author Uður Erdem Seyfi
 * @version 31.03.2019
 */

public class Balloon extends Circle implements Drawable{
    // properties
    static final int INITIAL_RADIUS = 25;
    static final int MAX_RADIUS = 100;
    
    /*
     * Default constructor
     */
    public Balloon(int x, int y){        
        super(INITIAL_RADIUS, x, y);
    }
    
    /*
     * Method that draws the circle
     * @param graphics - takes a graphics object
     */
    public void draw(Graphics g){
        int r = super.getRadius();
        int x = super.getX() - r;
        int y = super.getY() - r;
        
        g.drawOval(x, y, 2 * r, 2 * r);
    }
    
    /*
     * method that increases the size of the circle
     */
    public void grow(){
        super.setRadius( super.getRadius() + 1);
        if( super.getRadius() >= MAX_RADIUS){
            super.setSelected(true);
            super.setRadius(0);
        }
    }
    
}