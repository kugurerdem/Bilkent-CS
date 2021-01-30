package obj;

/*
 * LibraryBook Class
 * @author Uður Erdem Seyfi
 * @version 10.12.2018
 */

public class LibraryBook{
    // properties
    private String name;
    private String title;
    private String dueDate;
    private int timesLoan;
    
    private boolean onLoan;
    
    /*
     * Default Constructor
     * @param name - name
     * @param title - title
     */
    
    public LibraryBook(String name, String title){
        this.name = name;
        this.title = title;
        this.onLoan = false;
        this.timesLoan = 0;
    }
    
    /*
     * Copy Constructor
     * @param book - it takes LibraryBook that is going to be coppied
     */
    
    public LibraryBook(LibraryBook book){
        this.name = book.name;
        this.title = book.title;
        this.onLoan = book.onLoan;
        this.timesLoan = book.timesLoan;
    }
    
    /*
     * loan the book
     * @param dueDate - dueDate
     */
    public void loan(String dueDate){
        this.dueDate = dueDate;
        this.timesLoan = timesLoan + 1;
        this.onLoan = true;
    }
    
    /*
     * return book to the library
     */
    public void returnBook(){
        this.dueDate = "";
        this.onLoan = false;
    }
    
    /*
     * @return timesLoan
     */
    
    public int getTimesLoan(){
        return this.timesLoan;
    }
    
    /*
     * @return title
     */
    
    public String getTitle(){
        return this.title;
    }
    
    /*
     * @return onLoan
     */
    public boolean onLoan(){
        return onLoan;
    }
    
    /*
     * @Override
     * @return object information 
     */
    
    public String toString(){
        return "author name : " + this.name + " , title : " + this.title;
    }
    
    /*
     * Checks whether or not the title and name of a specific book is same or not
     * @return true if their name and title are the same
     */
    public boolean equals(LibraryBook book){
        return (book.name.equals(this.name) && book.title.equals(this.title) );
    }
    
    /*
     * Checks whether or not the title of a specific book is same or not
     * @return true titles are same
     */
    public boolean hasSameTitle(LibraryBook book){
        return this.title.equals( book.getTitle() );
    }
    
    /*
     * Checks whether or not the name of a specific book is same or not
     * @return true if names are same
     */
    public boolean hasSameName(LibraryBook book){
        return book.name.equals(this.name);
    }

}