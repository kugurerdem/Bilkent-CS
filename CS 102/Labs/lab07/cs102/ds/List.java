package cs102.ds;

/*
 * Custom list class for lab07
 * @author - Uður Erdem Seyfi
 * @version - 05.05.2019
 */

public class List{
    // properties
    Node head;
    
    /*
     * Default constructor
     */
    public List(){
        head = null;
    }
    
    /*
     * Method that adds an item to start of the list
     * @param item - item that is going to be added to the start of the list
     */
    public void addToHead(String item){
        Node tmp = head;
        head = new Node(item, tmp);
    }
    
    /*
     * Method that adds an item to end of the list
     * @param item - item that is going to be added to the end of the list
     */
    public void addToTail(String item){
        if( head != null){
            
            Node tmp = head;
            while( tmp.next != null){
                tmp = tmp.next;
            }
            
            tmp.next = new Node(item, null);
        } else{
            head = new Node(item, null);
        }
    }
    
    /*
     * Method that removes an item from beginning of the list
     * @return data - data of the removed item
     */
    public String removeFromHead(){
        if( head != null){
            String data = head.data;
            head = head.next;
            
            return data;
        }
        
        return null;
    }
    
    /*
     * Method that returns true if the list is empty, otherwise returns false
     * @return - truth value of the statement "list is empty"
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /*
     * Method that returns the data at specific inde
     * @param index - index of the data
     * @return string - data
     */
    public String  getData( int index){
        int count = 0;
        if( head != null ){
            Node temp = head;
            while( temp != null){
                if( count == index){
                    return temp.data;
                }
                
                temp = temp.next;
                count++;
            }
        }
        return null;
    }
    
    /*
     * Method that prints the data
     */
    public void print(){
        if( head != null){
            Node temp = head;
            while( temp != null){
                System.out.println( temp.data);
                temp = temp.next;
            }
        }
    }
    
    /**
     * Recursively prints the contents of the list starting from the specified node in reverse order.
     * @param n A reference to the current node for recursive purposes.
     */ 
    public void printReverse( Node n)
    {
        if ( n != null){
            System.out.println( n.data);
        }
        
        if ( n != head){
            printReverse( previous( n));
        }
    }
    
    /**
     * Recursively prints the entire contents of the list in reverse order.
     */ 
    public void printReverse(){
        printReverse( tail());
    }
    
    
    /*
     * Method that states whether or not the target value is in the list
     * @return boolean - true if target is in the list, otherwise false
     */
    public boolean contains( String target){
        if( head != null){
            Node temp = head;
            while( temp != null){
                if( target.equals( temp.data ) ){
                    return true;
                }
                
                temp = temp.next;
            }
        }
        
        return false;
    }
    
    /*
     * Method that checks whether or not the list is ordered
     * @return boolean - true if ordered, otherwise false
     */
    public boolean isOrdered(){
        boolean isOrdered = true;
        
        Node temp = head;
        if( temp != null){
            while( temp.next != null){
                if( temp.data.compareTo(temp.next.data) >= 0){
                    return false;
                }
                
                temp = temp.next;
            }
        }
        
        return true;
    }
    
    /**
     * Returns the node previous to the one specified.
     * @param n The node whose previous one will be returned.
     * @return The node previous to the one specified.
     */ 
    private Node previous( Node n) 
    {
        Node tmp = head;
        
        while ( tmp.next != n)
        {
            tmp = tmp.next;
        }
        return tmp;
    }
    
    /**
     * Returns the node next to the one specified.
     * @param n The node whose next one will be returned.
     * @return The node next to the one specified.
     */ 
    private Node next( Node n)
    {
        return n.next;
    }
    
    /**
     * Returns the last node of the list.
     * @return The last node of the list.
     */ 
    private Node tail()
    {
        Node tmp = head;
        
        if ( head != null)
        {
            while ( tmp.next != null)
            {
                tmp = tmp.next;
            }
        }
        return tmp;
    }
    
    /*
     * String representation of the list
     * @return String - representation of list
     */
    public String toString(){
        String str = "";
        
        Node temp = head;
        if( temp != null){
            str = str + temp.data;
            while( temp.next != null){
                temp = temp.next;
                str = str + "," + temp.data;
            }
        }
        // code here
        return str;
    }
    
    /*
     * Method that creates a list from array of strings
     * @return list
     */
    public static List createFrom(String[] arr){
        List list = new List();
        for(int i = 0; i < arr.length; i++){
            list.addToTail( arr[i]);
        }
        
        return list;
    }
    
    /*
     * Method that creates a list from a sequence of letters
     * @return list
     */
    public static List createFrom(String letters){
        List list = new List();
        for(int i = 0; i < letters.length(); i++){
            list.addToTail( ""+letters.charAt(i) );
        }
        
        return list;
    }
    
    /*
     * Method such that, given two lists, a & b, returns a new list that contains
     * only those elements of a and b, that are not on both lists.
     * @param a - first list
     * @param b - second list
     * @return merged list
     */
    public static List merge(List a, List b){
        List mergedList = new List();
        
        // Adding the elements that is in a but not in b to the mergedList
        Node temp_1 = a.head;
        while( temp_1 != null){
            if( !b.contains( temp_1.data) && !mergedList.contains( temp_1.data) ){
                mergedList.addToTail( temp_1.data);
            }
            temp_1 = temp_1.next;
        }
        
        // Adding the elements that is in b but not in a to the mergedList
        Node temp_2 = b.head;
        while( temp_2 != null){
            if( !a.contains( temp_2.data) && !mergedList.contains( temp_2.data) ){
                mergedList.addToTail( temp_2.data);
            }
            temp_2 = temp_2.next;
        }
        
        return mergedList;
    }
    
    
    
    /*
     * Private node class for using in the list
     */
    private class Node {
        String data; 
        Node next; 
        public Node( String data, Node next) {
            this.data = data; 
            this.next = next; 
        } 
    } // end class Node
}