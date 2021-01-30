import obj.Library;
import obj.LibraryBook;

/*
 * TestLibrary Class
 * @author Uður Erdem Seyfi
 * @version 10.12.2018
 */

public class TestLibrary{
    public static void main(String[] args){
        Library library = new Library();
        
        // Using isEmpty
        System.out.println( "Library is empty : " + library.isEmpty() );
        System.out.println( "library : " + library );
        
        // Using add method
        library.add("book1", "author1");
        library.add("book2", "author2");
        library.add("book3", "author3");
        library.add("book4", "author4");
        // library.add("book5", "author5"); throws error: "there is no place to add the book"
        
        System.out.println( "Library is empty : " + library.isEmpty() );
        System.out.println( "library : " + library );
        
        // Using remove method
        LibraryBook removableBook = new LibraryBook("author2", "book2");
        library.remove( removableBook );
        
        System.out.println( "Library is empty : " + library.isEmpty() );
        System.out.println( "library : " + library );
        
        // Using findByTitle method
        
        System.out.println( "findByTitle(\"book1\") : " + library.findByTitle("book1") );
        System.out.println( "findByTitle(\"book2\") : " + library.findByTitle("book2") );
        
        
    }
}