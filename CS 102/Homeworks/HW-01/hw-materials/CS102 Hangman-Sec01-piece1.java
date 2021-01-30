
import java.util.Scanner;

/**
 * @author Ege, Alp, Baykam, Zübeyir, Uğur, Agil
 * @version 11/02/2019
 * 
 */

public class HangmanGame {

   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      
      // Constants
      
      // Variables
      
      Hangman hangmanGame;
      char letter;
      
      // Code
      
      hangmanGame = new Hangman();
      
      System.out.println("Welcome to Hangman!");
      
      do {
      
         System.out.println(hangmanGame.getKnownSoFar());
         System.out.println("Used letters: " + hangmanGame.getUsedLetters());
         System.out.println("You have " + (hangmanGame.getMaxAllowedIncorrectTries() - hangmanGame.getNumOfIncorrectTries())
                             + " tries remaining");
         System.out.print("Please enter a letter to try: ");
         letter = scan.nextLine().charAt(0);
         hangmanGame.tryThis(letter);
         
      
      } while(!hangmanGame.isGameOver());
      
      if (hangmanGame.hasLost()) {
         
         System.out.println("You Lose!");
      
      } else {
      
         System.out.println("You Win!");
         System.out.println("The word was: " + hangmanGame.getKnownSoFar());
      
      }
      
   
   }

}