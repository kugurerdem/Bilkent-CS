package cardgame;

 /* Cards - Maintains a collection of zero or more playing cards.
  *         Provides facilities to create a full pack of 52 cards
  *         and to shuffle the cards.
  * @author Uður Erdem Seyfi
  * @version 04.03.2019
  */

public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    /*
     * Method that creates a new pack of cards
     */
    private void createFullPackOfCards()
    {
        for(int i = 0; i < NOOFCARDSINFULLPACK; i++){
            cards[i] = new Card(i);
        }
        
        valid = NOOFCARDSINFULLPACK;
    }
    
    /*
     * Method that shuffles the card set
     */
    public void shuffle()
    {
        Card[] new_cards = new Card[NOOFCARDSINFULLPACK];
        
        for(int i = 0; i < valid; i++){
            
            boolean placed = false;
            while(!placed){
                int index = (int) (Math.random() * valid);
                if( new_cards[index] == null){
                    new_cards[index] = cards[i];
                    placed = true;
                }
            }
        }
        
        cards = new_cards;
    }
    
    
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i = 0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards
