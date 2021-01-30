import junit.framework.TestCase;
import cs102.ds.List;

/**
 * A JUnit test case class.
 * @author - Uður Erdem Seyfi
 * @version - 05.05.2019
 */
public class ListTester extends TestCase {
    // properties
    List list;
    
    /*
     * This method is initialized before any test method is executed
     */
    protected void setUp(){
        list = new List();
    }
    
    /*
     * Checking .isEmpty() method
     */
    public void testIsEmpty() {        
        assertTrue(" list.isEmpty() expected true, but returned false" , list.isEmpty() ); // should be true
        list.addToTail("5");
        list.addToTail("hello");
        list.addToTail("hi");
        assertTrue(" list.isEmpty() expected false, returned true" , !list.isEmpty() ); // should be false
    }
    
    /*
     * Checking .addToHead() and .addToTail() methods
     */
    public void testAdd(){
        list.addToHead( "hiHead2");
        list.addToHead( "hiHead1");
        list.addToTail( "hiTail");
        list.print();

        assertTrue( "list.addToHead or list.hiTail is not working", list.toString().equals("hiHead1,hiHead2,hiTail") );
    }
    
    /*
     * Checking .removeFromHead() method
     */
    public void testRemoveFromHead(){
        list.addToTail("hiHead");
        list.addToTail("hello");
        
        boolean passedTest = false;
        String removedStr = list.removeFromHead();
        if( removedStr != null){
            passedTest = removedStr.equals("hiHead") ? true : passedTest;
        }
        assertTrue( " list.removeFromHead() does not work as expected", passedTest );
    }
    
    /*
     * Checking .getData(int i) method
     */
    public void testGetData(){
        list.addToTail("5");
        list.addToTail("hello");
        list.addToTail("hi");
        list.addToTail("hiTail");
        
        assertTrue( " list.getData(int i) does not work as expected", list.getData(0) == "5");
        assertTrue( " list.getData(int i) does not work as expected", list.getData(1) == "hello");
        assertTrue( " list.getData(int i) does not work as expected", list.getData(2) == "hi");
        assertTrue( " list.getData(int i) does not work as expected", list.getData(3) == "hiTail");
    }
    
    /*
     * checking .testContains(String info) method
     */
    public void testContains(){
        list.addToTail("5");
        assertTrue( " list.contains(String s) does not work as expected", list.contains("5") );
        assertTrue( " list.contains(String s) does not work as expected", !list.contains("hiHead") );
    }
    
    /*
     * checking .isOrdered() method
     */
    public void testIsOrdered(){
        list.addToTail("a");
        list.addToTail("b");
        assertTrue( " list.IsOrdered() does not work as expected", list.isOrdered() ); // "a","b" is ordered
        list.addToHead("c");
        assertTrue( " list.IsOrdered() does not work as expected", !list.isOrdered() ); // "c","a", "b" is not ordered
    }
    
    /*
     * checking List.createFrom(String[] arr) and List.createFrom(String letters) method
     */
    public void testCreateFrom(){
        // Checking List.createFrom(String[] arr)
        String[] strings = {"hello1","hi","hi2"};
        List convertedList = List.createFrom( strings);
        
        for(int i = 0; i < strings.length; i++){
            assertTrue(" List.createFrom(String[] arr) does not work as expected", convertedList.getData(i).equals( strings[i] ) );
        }
        
        // Checking List.createFrom(String letters)
        String letters = "abcd";
        List convertedList_2 = List.createFrom( letters);
        
        for(int i = 0; i < strings.length; i++){
            assertTrue(" List.createFrom(String[] arr) does not work as expected", convertedList_2.getData(i).equals( ""+letters.charAt(i) ) );
        }
        
    }
    
    /*
     * checking List.merge(List a, List b) method
     */
    public void testMerge(){
        List list_1 = List.createFrom("adc");
        List list_2 = List.createFrom("kbacr");
        
        List mergedList = List.merge( list_1, list_2);
        String expectedResult = "dkbr";
        String notExpectedResult = "ac";
        
        // the test is passed if (1) every element of expectedResult also an element of mergedList 
        // and (2) every element of notExpectedResult is not an element of mergedList. In other words,
        // if expectedResult and mergedList contains exactly the same elements.
        
        // part 1
        for(int i = 0; i < expectedResult.length(); i++){
            if( !mergedList.contains( "" +expectedResult.charAt(i) )){
                assertTrue("List.merge() does not work as expected", false);
            }
        }
        
        // part 2
        for(int i = 0; i < notExpectedResult.length(); i++){
            if( mergedList.contains( "" + notExpectedResult.charAt(i)) ){
                assertTrue("List.merge() does not work as expected", false);
            }
        }
        
    }
    
    /*
     * Method that prints to console
     */
    public void testPrint(){
        list.addToTail("hi");
        list.addToTail("hi1");
        list.addToTail("hi2");
        
        list.print();
        list.printReverse();
        
        assertTrue("", true);
    }
    
}
