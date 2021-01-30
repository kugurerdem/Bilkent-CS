import java.util.Iterator;

/*
 * IntBag class
 * @author Uður Erdem Seyfi
 * @version 10.03.2019
 */

public class IntBag implements Iterator{
    // Properties
    private int valid;
    private int index; 
    private int[] bag;
    
    /*
     * Default constructor for IntBag
     */
    public IntBag(){
        valid = 0;
        index = 0;
        bag = new int[100];
    }
    
    /*
     * Constructor with max number of elements with bag
     */
    public IntBag(int max){
        valid = 0;
        bag = new int[max];
    }
    
    /*
     * Method that adds given num to the bag
     */
    public void add(int num){
        if(valid >= bag.length){
            expand();
        }
        
        bag[valid] = num;
        valid++;
    }
    
    /*
     * Method that adds given num to the bag at specific index
     */
    public void add(int index, int num){
        if(valid >= bag.length){
            expand();
        }
        
        for(int i = valid; i > index; i--){
            bag[i] = bag[i-1];
        }
        
        bag[index] = num;
        valid++;
    }
    
    /*
     * Method that removes a num from the bag at specific index
     */
    public void remove(int index){
        for(int i = index; i < valid - 1; i++){
            bag[i] = bag[i + 1];
        }
        
        valid--;
    }
    
    /*
     * Method that gets a num from the bag at specific index
     * @return - bag[index]
     */
    public int get(int index){
        if(index >= 0 && index < valid){
            return bag[index];
        }
        
        throw new Error("out of boundary");
    }
    
    /*
     * Method that returns the size of the collection
     * @return - size of the collection
     */
    public int size(){
        return valid;
    }
    
    /*
     * A method that expands the bag's size by %30
     */
    public void expand(){
        int[] new_bag = new int[bag.length + (int) Math.ceil(bag.length * 0.3)];
        for(int i = 0; i < valid; i++){
            new_bag[i] = bag[i];
        }       
        bag = new_bag;
    }
    
    /*
     * A method that returns true if the given num is in the bag
     * @return - the statement that num is in the bag
     */
    public boolean contains(int num){
        for(int i = 0; i < valid; i++){
            if(bag[i] == num){
                return true;
            }
        }        
        return false;
    }
    
    /*
     * A method that returns the indexes of a given value
     * @param - value
     * @return - the set of indexes of the value
     */
    public IntBag findAll(int value){
        IntBag indexes = new IntBag();
        
        for(int i = 0; i < valid; i++){
            if( bag[i] == value ){
                indexes.add(i);
            }
        }
        
        return indexes;
    }
    
    /*
     * A method that gives string information about the class
     * @return - string information
     */
    public String toString(){
        String str;
        
        str = "[ ";
        for(int i = 0; i < valid; i++){
            str = str + bag[i] + ((i != valid - 1)? ", " : "");
        }
        str = str + " ]";
        
        return str;
    }
    
    /*
     * Method that returns the next integer
     * @return next integer
     */
    public Object next(){
        return new Integer(bag[index++]);
    }
    
    /*
     * Method that states if there is a next element
     * @return true if there is a next element, otherwie false
     */
    public boolean hasNext(){
        return index < valid;
    }
    
    /*
     * Inner iterator class for the bag 
     */
    class InnerIntBagIterator implements Iterator{
        // properties
        IntBag aBag;
        int index;
        
        /*
         * Default constructor
         * @param - bag
         */
        public InnerIntBagIterator(IntBag bag){
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
    }
    
    /*
     * returns the iterator for this object
     * @return iterator
     */
    public Iterator iterator(){
        return new InnerIntBagIterator(this);
    }
}