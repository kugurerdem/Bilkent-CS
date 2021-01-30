/* Authors
 * Oðuz Orhun Tüzgen
 * Yiðit Harun
 * Ahmet Ayberk Yýlmaz
 * Ýlhan Koç
 * Salman Soomro
 * Mehmet Akif Çelik
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