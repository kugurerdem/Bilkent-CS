import java.util.ArrayList;

/*
 * ShapeContainer class, a class that contains Shapes
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public class ShapeContainer{
    ArrayList<Shape> shapes;
    
    
    /*
     * Default constructor
     */
    public ShapeContainer(){
        shapes = new ArrayList<Shape>();
    }
    
    /*
     * method that adds a shape to the container
     * @param s - Shape
     */
    public void add(Shape s){
        shapes.add(s);
    }
    
    /*
     * Method that returns the total area of the shapes
     * @return - total area
     */
    public double getArea(){
        // computer the total area
        double total = 0;
        for(int i = 0; i < shapes.size(); i++){
            total = total + shapes.get(i).getArea();
        }
        
        //return it
        return total;
    }
    
    /*
     * Method that finds the first Shape that contains x, y
     * @param x - x position
     * @param y - y position
     */
    public Shape findShapeContains(int x, int y){
        for(int i = 0; i < shapes.size(); i++){
            Shape shape = shapes.get(i);
            if( ((Selectable) shape).contains(x,y) ){
                return shape;
            }
        }
        
        return null;
    }
    
    /*
     * Method that removes all selected items from the list
     */
    public void remove(){
        int index = 0;
        
        while( index < shapes.size() ){
            Shape shape = shapes.get(index);
            if( ((Selectable) shape).getSelected() ){
                shapes.remove(index);
            } else{
                index++;
            }
        }
    }
    
    
    /*
     * String information about the class
     * @return string based information
     */
    public String toString(){
        String str = "";
        
        for(int i = 0; i < shapes.size(); i++){
            str = str + "\n shape " + i + "\n\n" + shapes.get(i);
            str = str + " area of the shape: " + shapes.get(i).getArea() + "\n";
        }
        
        str = str + "\n total area is " + this.getArea() + "\n";
        
        return str;
    }
}