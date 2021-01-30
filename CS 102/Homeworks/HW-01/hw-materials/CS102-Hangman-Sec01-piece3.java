
/**
 * tryThis method returns the number of occurences of the g�ven letter in the secret world.
 * @param letter is a char.
 * @return count.
 * @author Can Alpay, Do�a Tansel, Ege �nalan, Utku Seyfeli, Kaan Erkan, G�ktan G�d�kbay
 */   
public int tryThis( char letter){
   int count;
   count = 0;
   
   for( int i = 0; i < getUsedLetters().length(); i++){
      if( getUsedLetters().charAt(i) == letter)
         return -2;
   }
   usedLetters.append( letter);
   for( int i = 0; i < secretWord.length(); i++){
      if( secretWord.charAt(i) == letter){
         count = count + 1; 
         knownSoFar.setCharAt( i, letter);
      }
   }
   if( isGameOver())
      return -3;
   if( count == 0)
      return -1;

   return count;
}