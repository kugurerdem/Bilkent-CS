import obj.LibraryBook;

/*
 * TestLibraryBook Class
 * @author U�ur Erdem Seyfi
 * @version 10.12.2018
 */

public class TestLibraryBook{
    public static void main(String[] args){
        // create variables
        LibraryBook book_1, 
                    book_2, 
                    book_3,
                    book_4,
                    book_5;
        
        // assign values to variables
        book_1 = new LibraryBook("name", "title");
        book_2 = book_1;
        book_3 = new LibraryBook("name", "title");
        book_4 = new LibraryBook("name2", "tite2");
        
        book_5 = new LibraryBook(book_1);
        
        // Checking which books are equal which books are not
        System.out.println("book_1 == book_2 : " + (book_1 == book_2) );
        System.out.println("book_1.equals(book_2) : " + book_1.equals(book_2) );
        
        System.out.println("book_1 == book_3 : " + (book_1 == book_3) );
        System.out.println("book_1.equals(book_3) : " + book_1.equals(book_3) );
        
        System.out.println("book_1 == book_4 : " + (book_1 == book_4) );
        System.out.println("book_1.equals(book_4) : " + book_1.equals(book_4) );
        
        System.out.println("book_5 == book_1 : " + (book_1 == book_5) );
        System.out.println("book_5.equals(book_1) : " + book_1.equals(book_5) );
        
        
    }
}