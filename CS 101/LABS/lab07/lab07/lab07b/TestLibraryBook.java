import obj.LibraryBook;

/*
 * TestLibraryBook Class
 * @author Uður Erdem Seyfi
 * @version 04.12.2018
 */

public class TestLibraryBook{
    public static void main(String[] args){
        // create variables
        LibraryBook book;
        
        // assign values to variables
        book = new LibraryBook("name","title");
        
        book.loan("15.15.15");
        book.returnBook();
        
        book.loan("25.15.15");
        book.returnBook();
        
        System.out.println(book);
        
    }
}