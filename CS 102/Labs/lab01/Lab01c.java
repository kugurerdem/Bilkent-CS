import java.util.Scanner;

/*
 * Lab01c
 * @author Uður Erdem Seyfi
 * @version 18.02.2019
 */

public class Lab01c{
    
    /*
     * main method which executes the program
     * @param args - arguments
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        // declaring variables
        IntBag bag;
        int maxCapacity;
        int testValue;
        IntBag locations;
        boolean quit;
        
        // assigning values to variables
        bag = null;
        locations = null;
        quit = false;
        testValue = -1;
        
        do{
            // introducing commands that user can use
            System.out.println(" 1. Create a new empty collection with a specified maximum capacity (any previous values are lost!");
            System.out.println(" 2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)");
            System.out.println(" 3. Print the collection of values.");
            System.out.println(" 4. Add a value to the collection of values at a specified location");
            System.out.println(" 5. Remove the value at a specified location from the collection of values");
            System.out.println(" 6. Read a single test value.");
            System.out.println(" 7. Compute the set of locations of the test value within the collection* (see note below).");
            System.out.println(" 8. Print the set of locations.");
            System.out.println(" 9. Quit the program.");
            
            // get the command
            int command = scan.nextInt();
            
            // check commands
            if( command == 1){
                System.out.println(" Specify the maximum capacity : " );
                
                maxCapacity = scan.nextInt();
                bag = new IntBag(maxCapacity);
                
            } else if( command == 2){
                
                // if bag is null print error message
                if( bag == null){
                     System.out.println( " You haven't initialized the collection. \n");
                } else{
                    System.out.println( "Enter values : ");
                    // get new values until user enters a negative one
                    int value = scan.nextInt();
                    while( value >= 0){
                        bag.add( value);
                        value = scan.nextInt();
                    }
                } 
                
            } else if( command == 3){
                // print the bag
                System.out.println( bag + " \n");
                
            } else if( command == 4){
                // if bag is null print error message
                if( bag == null){
                    System.out.println( " You haven't initialized the collection. \n");
                } else{
                    
                    System.out.println(" Specify the index : ");
                    int index = scan.nextInt();
                    System.out.println(" Enter the value : ");
                    int value = scan.nextInt();
                    
                    bag.add(index, value);
                }
                
            }else if( command == 5){
                // if bag is null print error message
                if( bag == null){
                    System.out.println( " You haven't initialized the collection. \n");
                } else{
                    System.out.println(" Specify the index : ");
                    int index = scan.nextInt();
                    
                    // remove the value at the given index
                    bag.remove(index);
                }
            }else if( command == 6){
                System.out.println(" Enter a value to test :");
                testValue = scan.nextInt();
                // If test value is not valid, warn the user
                if(testValue < 0){
                    System.out.println(" Enter a non-negative number \n");
                } 
                
            }else if( command == 7){
                // If a valid test value is not entered print error message
                if( testValue < 0){
                    System.out.println(" You did not specify a positive test value \n");
                } else{
                    locations = bag.findAll(testValue);
                    System.out.println(" Locations has been computed \n");
                }
            }else if( command == 8){
                // If locations have not been computer print error message
                if(locations == null){
                    System.out.println(" You did not compute the locations. \n");
                } else{
                    // print the locations
                    System.out.println(locations);
                }
            }else if( command == 9 ){
                quit = true;
            } else{
                System.out.println(" Your command is not valid");
            }
            
        }while(!quit);
        
        System.out.println(" You quit the program.");
        
    } 
}