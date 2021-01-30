import java.util.*;

/*
 * IntBagIterator class
 * @author Uður Erdem Seyfi
 * @version 10.03.2019
 */

public class IntBagIterator implements IntIterator{
    // properties
    IntBag aBag;
    int index;
    
    /*
     * Default constructor
     * @param - bag
     */
    public IntBagIterator(IntBag bag){
        aBag = bag;
    }
    
    /*
     * Method that returns the next integer
     * @return next integer
     */
    public Object next(){
        Integer integer = new Integer(aBag.get(index));
        index++;
        return integer;
    }
    
    /*
     * Method that states if there is a next element
     * @return true if there is a next element, otherwie false
     */
    public boolean hasNext(){
        return index < aBag.size();
    }
    
    /*
     * Method that returns next int
     * @return int
     */
    public int nextInt(){
        return (int) next();
    }
}