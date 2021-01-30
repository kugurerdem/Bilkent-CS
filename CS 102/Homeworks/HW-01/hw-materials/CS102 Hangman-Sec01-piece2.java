/* Authors
 * O�uz Orhun T�zgen
 * Yi�it Harun
 * Ahmet Ayberk Y�lmaz
 * �lhan Ko�
 * Salman Soomro
 * Mehmet Akif �elik
 */ 
public class Hangman
{
    // properties
   
    // constructors
   public Hangman()
   {
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      usedLetters = new StringBuffer();
      secretWord = chooseSecretWord();
      allLetters = new StringBuffer("abcdefghijklmnopqrstuwxyz");
      knownSoFar = new StringBuffer(secretWord.length());
      
      for (int i = 0; i < secretWord.length(); i++)
      {
         knownSoFar.append("*");
      }
   }
    // methods