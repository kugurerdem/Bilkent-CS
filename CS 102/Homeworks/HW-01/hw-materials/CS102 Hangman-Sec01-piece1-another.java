import java.util.Scanner;
/**
 * __The program to play hangman___ 
 * @author Group6: Cihan Can Kýlýç - Özgür Mert Emir - Efe Macit - Efe Korkmazhan - Yiðit Erkal - Göktuð Çaðýran
 * @version __11.02.2019__
 */ 
public class HangmanMain
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      //variables
      Hangman hangman;
      String newWord;
      char letterTry;
      //program
      hangman = new Hangman();
      hangman.chooseSecretWord();
      hangman.getKnownSoFar();
      System.out.println( hangman.getAllLetters );
      System.out.println( "Maximum allowed tries are " + hangman.getMaxAllowedIncorrectTries );
      while( !hangman.isGameOver() )
      {
         System.out.println( "Letters used are: " + hangman.getUsedLetters );
         System.out.println( "Number of incorrect tries left: " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) );
         System.out.println( "Choose a new letter: " );
         letterTry = scan.next();
         hangman.tryThis( letterTry );
         if( hangman.tryThis( letterTry ) == 0 )
         {
            System.out.println( "Letter not found." );
         }
         else
         {
            System.out.println( "There is/are " + hangman.tryThis( letterTry ) + " of this letter in the word " );
         }
         System.out.println( hangman.getKnownSoFar() );
      }
      if( hangman.hasLost() )
      {
         System.out.println( "You lost the game!!!" );
      }
      else
      {
         System.out.println( "You won!!!" );
      }
      
   
   }

}