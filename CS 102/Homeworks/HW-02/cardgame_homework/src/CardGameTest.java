import java.util.Scanner;
import cardgame.*;

/*
 * CardGameTest
 * @Uður Erdem Seyfi
 * @version 06.03.2019
 */
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        Player     p1;
        Player     p2;
        Player     p3;
        Player     p4;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.shuffle();
        cards.testOnlyPrint();  // remove method after testing!
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        
        // test Player class
        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");
        p4 = new Player("p4");
        
        p1.add( new Card(1) );
        System.out.println( p1.playCard() );
        
        // test CardGame class too?
        game = new CardGame(p1, p2, p3, p4);
        System.out.println();
        
        Card card = p1.playCard();
        game.playTurn(p1, card);
        
        card = p2.playCard();
        game.playTurn(p2, card);
        
        card = p3.playCard();
        game.playTurn(p3, card);
        
        card = p4.playCard();
        game.playTurn(p4, card);
        
        System.out.println( game.showScoreCard() );
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
