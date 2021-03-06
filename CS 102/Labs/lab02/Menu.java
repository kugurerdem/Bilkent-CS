import classes.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Menu class
 * @author U�ur Erdem Seyfi
 * @version 03.03.2019
 */

public class Menu{
    
    /*
     * Program execution
     */
    public static void main(String[] args){
        
        // variables
        ArrayList<MySimpleURLReader> list;
        boolean running;
        Scanner scan;
        
        // assigning values to variables
        list = new ArrayList<MySimpleURLReader>();
        running = true;
        scan = new Scanner(System.in);
        
        // program
        System.out.println( "Welcome to the poem reading program!" );
        
        do{
            // Command list
            System.out.println("(1) Enter the url of the poem to add to collection. ");
            System.out.println("(2) List all poems in the collection. ");
            System.out.println("(3) Quit.");
            
            // get the command
            int command = scan.nextInt();
            
            if( command == 1){
                MySimpleURLReader reader;
                boolean alreadyInTheList = false; // false because we haven't checked if it is in the list yet
                
                // get url
                System.out.println("Enter url : ");
                String url = scan.next();
                
                // checks if the url is already in the list
                for(int i = 0; i < list.size(); i++){
                    if( list.get(i).getURL().equals(url) ){
                        alreadyInTheList = true;
                        break;
                    }
                }
                
                // check whether it is a .txt file or .html file
                if( alreadyInTheList ){
                    System.out.println(" You entered an url that already in the list. ");
                } else if( url.contains(".txt") ){
                    reader = new MySimpleURLReader(url);
                    list.add(reader);
                } else if( url.contains(".htm") || url.contains(".html") ){
                    reader = new HTMLFilteredReader(url);
                    list.add(reader);
                } else{
                    System.out.println("Be sure you entered html or txt url");
                }
                
            } else if( command == 2){
                // boolean to return back
                boolean back = false;
                
                do{
                    // inform the user about command list
                    for(int i = 0; i < list.size(); i++){
                        System.out.println( (i+1) + ". " + list.get(i).getName() );
                    }
                    System.out.println( (list.size()+1) + ". back" ); 
                    
                    // get command from the user
                    int c = scan.nextInt();
                    
                    // check which command has been given
                    if( c == (list.size() + 1) ){
                        back = true;
                    } else if( c <= list.size() && c > 0){
                        System.out.println( list.get( c - 1 ).getPageContents() );
                    } else{
                        System.out.println("Be sure you select a command from the list above. ");
                    }
                    
                }while(!back);
            
            } else if( command == 3){
                running = false;
            }
            
        }while(running);
    }
        
}