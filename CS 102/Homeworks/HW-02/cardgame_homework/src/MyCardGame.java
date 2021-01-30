import java.util.Scanner;
import cardgame.*;

/*
 * MyCardGame - provides a menu allowing any of the players to play their card,
 *              an option to see the score card, and one to quit the game at any time.
 *              When the game is over it dislays the winners.
 * @author Uður Erdem Seyfi 
 * @version 06.03.2019
 */
public class MyCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of MyCardGame\n");
        
        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        
        // VARIABLES
        Player     p1, p2, p3, p4;
        CardGame   game;
        int        selection;
        
        // PROGRAM CODE

        // create players...
        p1 = new Player( "David");
        p2 = new Player( "Ugur");
        p3 = new Player( "Ayse");
        p4 = new Player( "Mahmut");
        
        // create game with the 4 players...
        game = new CardGame( p1, p2, p3, p4);
        
        // display menu, get and process selection, until exit
        do 
        {
            // If game is over, ask user if they want to play it again
            if( game.isGameOver() ){
                Player[] winners = game.getWinners();
                
                System.out.println( "\n\nGame is over \n" );
                System.out.println( "Winner(s) : " );
                for(int i = 0; i < winners.length; i++){
                    System.out.println(winners[i]);
                }
                
                System.out.println("Do you want to start a new game? y/n");
                String command = scan.next();
                
                // if yes create a new game
                if(command.equals("y")){
                    // create players...
                    p1 = new Player( "David");
                    p2 = new Player( "Ugur");
                    p3 = new Player( "Ayse");
                    p4 = new Player( "Mahmut");
                    
                    // create game with the 4 players...
                    game = new CardGame( p1, p2, p3, p4);
                    selection = -1; // just continues the while loop
                } else{
                    selection = MENU_EXIT; // exits from the menu
                }
            } else{
                // display menu
                System.out.println();
                System.out.println( "MyCardGame   Round: " + game.getRoundNo() 
                                       + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
                System.out.println();
                System.out.println( MENU_PLAY_P1 + " - Player " + p1 + " plays" );
                System.out.println( MENU_PLAY_P2 + " - Player " + p2 + " plays" );
                System.out.println( MENU_PLAY_P3 + " - Player " + p3 + " plays" );
                System.out.println( MENU_PLAY_P4 + " - Player " + p4 + " plays" );
                System.out.println( MENU_SCORES  + " - Show scores" );
                
                // ask for and get selection
                System.out.println();
                System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
                
                selection = scan.nextInt();
                // process selection
                if ( selection == MENU_PLAY_P1 )
                    play( p1, game);
                
                else if ( selection == MENU_PLAY_P2 )
                    play( p2, game);
                
                else if ( selection == MENU_PLAY_P3 )
                    play( p3, game);
                
                else if ( selection == MENU_PLAY_P4 )
                    play( p4, game);
                
                else if ( selection == MENU_SCORES )
                    System.out.println( game.showScoreCard() );
                //System.out.println( "ToDo..." );
                
                else if ( selection != MENU_EXIT)
                    System.out.println( "Invalid selection! \n" );
            }
        } while ( selection != MENU_EXIT);
        
        System.out.println( "\nEnd of MyCardGame\n" );  
    }

    /*
     * Method that plays a card for p in the game
     * @param player
     * @param game
     * @return if player can play a card return true, otherwise false
     */
    private static boolean play( Player p, CardGame game)
    {
        Card       c;
        boolean    accepted;
        
        c = p.playCard();
        
        accepted = game.playTurn(p, c);
        if(accepted){
           System.out.println(p + " played " + c);
        }else{
            p.add(c);
            System.out.println("Wrong turn! ");
        }
        
        return accepted;
    }
    
} // end class MyCardGame
