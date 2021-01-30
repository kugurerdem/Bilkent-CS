import java.util.Scanner;

/*
 * ShapeTester class
 * @author Uður Erdem Seyfi
 * @version 11.03.2019
 */

public class ShapeTester{
    /*
     * main method that runs the test
     * @param args - arguments
     */
    public static void main(String[] args){
        // declaring variables
        Scanner scan;
        ShapeContainer container;
        boolean quit;
        
        //assignin values to variables
        scan = new Scanner(System.in);
        container = new ShapeContainer();
        
        // program
        quit = false;
        do{
            int command;
            // list of commands
            System.out.println(" 1. Add a shape ");
            System.out.println(" 2. Compute and get total area ");
            System.out.println(" 3. Information for shapes ");
            System.out.println(" 4. Find the shape that contains given x and y, then select it ");
            System.out.println(" 5. Remove all selected shapes from the list ");
            
            // get command from the user 
            command = scan.nextInt();
            
            if( command == 1 ){
                int c;
                
                // list of shapes
                System.out.println(" 1. Add rectangle ");
                System.out.println(" 2. Add square ");
                System.out.println(" 3. Add circle ");
                System.out.println(" any other number to go back ");
                
                // get the command from the user
                c = scan.nextInt();
                
                // If the shape command is invalid notify the user
                if( c != 1 && c != 2 && c != 3){
                    System.out.println(" Your command is invalid!");
                }else{
                    // otherwise get x,y
                    System.out.println(" Enter x positon : ");
                    int x = scan.nextInt();
                    
                    System.out.println(" Enter y positon : ");
                    int y = scan.nextInt();
                    
                    // If the shape is rectangle do these
                    if( c == 1){
                        System.out.println(" Enter width : ");
                        int width = scan.nextInt();
                        System.out.println(" Enter height : ");
                        int height = scan.nextInt();
                        
                        Shape s = new Rectangle(width, height, x, y);
                        // s.setLocations(x, y);
                        
                        container.add(s);
                    } else if( c == 2){
                        // If the shape is square do these
                        System.out.println(" Enter side length: ");
                        int side = scan.nextInt();
                        
                        Shape s = new Square(side, x, y);
                        // s.setLocations(x, y);
                        container.add(s);
                    } else if( c == 3){
                        // If the shape is circle do these
                        System.out.println(" Enter radius: ");
                        int r = scan.nextInt();
                        
                        Shape s = new Circle(r, x, y);
                        // s.setLocations(x, y);
                        container.add(s);
                    }
                }
                
            } else if( command == 2){
                // print the total area
                System.out.println( " total area is : " + container.getArea() );
            } else if( command == 3){
                // print the container knowledge
                System.out.println( container );
            } else if( command == 4){
                // get the x,y input from the user
                System.out.println(" Enter x positon : ");
                int x = scan.nextInt();
                
                System.out.println(" Enter y positon : ");
                int y = scan.nextInt();
                
                // find the shape that contains x,y
                Shape s = container.findShapeContains(x, y);
                
                // give information about 
                if( s == null ){
                    System.out.println(" There is no such shape ");
                } else{
                    ((Selectable) s).setSelected( !((Selectable) s).getSelected() );
                    System.out.println(" The shape's selected state is toggled ");
                    System.out.println(" Properties of the shape are : \n \n" + s.toString() );
                }
            } else if( command == 5){
                // remove all the selected items
                container.remove();
            } else{
                // quit
                quit = true;
                System.out.println(" Invalid command ");
            }
        
        }while(!quit);
        
    }
}
                      