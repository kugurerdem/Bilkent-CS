import java.util.*;

/*
 * TestIterators class
 * @author Uður Erdem Seyfi
 * @version 10.03.2019
 */

public class TestIterators{
    public static void main(String[] args){
        // variables
        Iterator i, j;
        IntBag bag;
        
        // assigning values to variables
        bag = new IntBag();
        bag.add(1);
        bag.add(3);
        bag.add(2);
        
        i = new IntBagIterator(bag);
        
        // program
        while ( i.hasNext() ) 
        {
            System.out.println( i.next() );
            
            // j = new IntBagIterator( bag);
            j = bag.iterator();
            
            while ( j.hasNext() )
            {
                System.out.println( "--" + j.next() );
            }
        }
    
    }
}