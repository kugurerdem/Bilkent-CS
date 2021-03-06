package obj;

/*
 * Library Class
 * @author U�ur Erdem Seyfi
 * @version 10.12.2018
 */

public class Library{
    
    // Properties
    private LibraryBook book_1, book_2, 
        book_3, book_4;
    
    /*
     * Default Constructor
     */
    
    public Library(){
        this.book_1 = null;
        this.book_2 = null;
        this.book_3 = null;
        this.book_4 = null;
    }
    
    /*
     * @return the statement all books are null 
     */
    
    public boolean isEmpty(){
        return (this.book_1 == null && this.book_2 == null && this.book_3 == null && this.book_4 == null); 
    }
    
    /*
     * Function that adds book
     */
    
    public void add(String title, String author){
        
        if(this.book_1 == null){
            this.book_1 = new LibraryBook(author, title);
        } else if(this.book_2 == null){
            this.book_2 = new LibraryBook(author, title);
        } else if(this.book_3 == null){
            this.book_3 = new LibraryBook(author, title);
        } else if(this.book_4 == null){
            this.book_4 = new LibraryBook(author, title);
        } else{
            throw new Error("There is no place to add the book");
        }
        
    }
    
    /*
     * Function that removes a specific book
     * @return true if the book is removed false if it is not found
     */
    
    public boolean remove(LibraryBook book){
        if(this.book_1.equals(book)){
            this.book_1 = null;
        } else if(this.book_2.equals(book)){
            this.book_2 = null;
        } else if(this.book_3.equals(book)){
            this.book_3 = null;
        } else if(this.book_4.equals(book)){
            this.book_4 = null;
        } else{
            return false;
        }
        
        return true;
    }
    
    /*
     * Function that find a book by its title
     * @return book with the specific title
     */
    public LibraryBook findByTitle(String title){
        LibraryBook bk = new LibraryBook("xxx", title);
        
        if(this.book_1 != null){
            if( bk.hasSameTitle(this.book_1)){
                return this.book_1;
            }
        } else if(this.book_2 != null){
            if( bk.hasSameTitle(this.book_2)){
                return this.book_2;
            }
        }  else if(this.book_3 != null){
            if( bk.hasSameTitle(this.book_3)){
                return this.book_3;
            }
        } else if(this.book_4 != null){
            if( bk.hasSameTitle(this.book_4)){
                return this.book_4;
            }
        } 
        
        return null;
    }
    
    
    /*
     * @return string information about class
     */
    public String toString(){
        return "book_1 : \n " + this.book_1 + "\nbook_2 : \n " + this.book_2 + "\nbook_3 : \n " + this.book_3 + "\nbook_4 : \n " + this.book_4;
    }
}