package obj;

/*
 * LibraryBook Class
 * @author Uður Erdem Seyfi
 * @version 04.12.2018
 */

public class LibraryBook{
    private String name;
    private String title;
    private String dueDate;
    private int timesLoan;
    
    private boolean onLoan;
    
    /*
     * Constructor
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
     * @return onLoan
     */
    public boolean onLoan(){
        return onLoan;
    }
    
    /*
     * @return object information 
     */
    
    public String toString(){
        return " author name : " + this.name + "\n title : " + this.title + "\n dueDate : " + this.dueDate + "\n timesLoan : " + this.timesLoan +"\n onLoan : " + this.onLoan;
    }

}