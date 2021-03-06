package obj;
import java.util.ArrayList;

/*
 * Library Class
 * @author U�ur Erdem Seyfi
 * @version 18.12.2018
 */

public class Library{
    
    // Properties
    private ArrayList<LibraryBook> books;
    
    /*
     * Default Constructor
     */
    
    public Library(){
        this.books = new ArrayList<LibraryBook>();
    }
    
    /*
     * @return the statement all books are null 
     */
    
    public boolean isEmpty(){
        
        for(int i = 0; i < books.size(); i++){
            if( books.get(i) != null ){
                return false;
            }
        }
        
        return true;
        
    }
    
    /*
     * Function that adds book
     */
    
    public void add(String title, String author){
        // add book to library
        this.books.add( new LibraryBook(author, title) );       
    }
    
    /*
     * Function that removes a specific book
     * @return true if the book is removed false if it is not found
     */
    
    public boolean remove(LibraryBook book){
        
        // check all books, when found the book remove the book
        for(int i = 0; i < books.size(); i++){
            if( this.books.get(i).equals(book) ){
                this.books.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    /*
     * Function that find a book by its title
     * @return book with the specific title
     */
    public LibraryBook findByTitle(String title){
        LibraryBook bk = new LibraryBook("xxx", title);
        
        for(int i = 0; i < this.books.size(); i++){
            LibraryBook book = this.books.get(i);
            
            if( book != null ){
                if(bk.hasSameTitle( book ) ){
                    return book;
                }
            }
        }
        
        return null;
    }
    
    
    /*
     * @return string information about class
     */
    public String toString(){
        String str;
        
        str = "";
        
        for(int i = 0; i < this.books.size(); i++){
            str = str + "\n book " + (i+1) + " is " + this.books.get(i);
        }
        
        return str;
    }
}