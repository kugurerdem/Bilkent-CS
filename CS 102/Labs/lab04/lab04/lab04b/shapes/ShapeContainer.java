package shapes;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;

/*
 * ShapeContainer class, a class that contains Shapes
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public class ShapeContainer implements Iterable{
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
    
//    /*
//     * method that returns the shape at a given index
//     * @param index - index
//     * @return - shape at a given index
//     */
//    public Shape get(int index){
//        return shapes.get(index);
//    }
    
    /*
     * method that returns the size of the container
     * @return - container size
     */
    public int size(){
        return shapes.size();
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
     * returns the number of shapes containing the point x,y 
     * and sets the selected property of those shapes to true.
     * @param x - x position
     * @param y - y position
     * @return number - number of shapes at given position
     */
    public int selectAllAt(int x, int y){
        int number = 0;
        
        for(int i = 0; i < shapes.size(); i++){
            Shape shape = shapes.get(i);
            if( ((Selectable) shape).contains(x,y) ){
                ((Selectable) shape).setSelected(true);
                number++;
            }
        }
        
        return number;
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
    
    /*
     * Method that returns an iterator
     * @return - iterator
     */
    public Iterator iterator(){
        return new ShapeIterator(this);
    }
    
    /*
     * Inner class shape iterator
     * @param container
     */
    public class ShapeIterator implements Iterator{
        // properties
        ShapeContainer container;
        int index;
        
        /*
         * Default constructor
         * @param - bag
         */
        public ShapeIterator(ShapeContainer cont){
            container = cont;
            index = 0;
        }
        
        /*
         * Method that returns the next integer
         * @return next integer
         */
        public Object next(){
            return shapes.get(index++);
        }
        
        /*
         * Method that states if there is a next element
         * @return true if there is a next element, otherwie false
         */
        public boolean hasNext(){
            return index < container.size();
        }
        
    }
}