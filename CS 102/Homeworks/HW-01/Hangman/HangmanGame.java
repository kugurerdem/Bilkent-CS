import java.util.Scanner;

/*
 * Hangman class
 * @author Uður Erdem Seyfi and section01 students
 * @version 16/02/2019
 */

public class HangmanGame {

   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      
      // Variables
      String input;
      char letter;
      Hangman hangman;
      
      // Code
      hangman = new Hangman();
      
      System.out.println("Welcome to Hangman!");

      do {
      
         System.out.println(hangman.getKnownSoFar());
         System.out.println("Used letters: " + hangman.getUsedLetters());
         System.out.println("You have " + (hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries())
                             + " tries remaining");
         System.out.print("Please enter a letter to try: ");
         
         // Get input and check if it is empty or not, if it is not don't do anything.
         input = scan.nextLine();
         if( input.length() > 0){
             letter = input.charAt(0);
             int found = hangman.tryThis(letter);
             
             // See whether letter is already used, or is not valid or not found etc. 
             // If there is no problem print the count of the letter in the word
             if(found == -3){
                 System.out.println("Game over.");
             }else if(found == -2){
                 System.out.println("Letter is already used");
             } else if(found == -1){
                 System.out.println("Letter is not valid");
             } else if(found == 0){
                 System.out.println("Letter not found");
             } else{
                 System.out.println("There is/are " + found + " of this letter in the word ");
             }
             System.out.println();
         } 
      } while(!hangman.isGameOver());
      
      if (hangman.hasLost()) {
          System.out.println("You Lose!");
      } else {
         System.out.println("You Win!");
         System.out.println("The word was: " + hangman.getKnownSoFar());
      }
   }
}