package cardgame;

/**
 * Card - a single playing card
 * @author U�ur Erdem Seyfi
 * @version 04.03.2019
 */
public class Card
{
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NOOFCARDSINSUIT = 13;
    
    // properties
    int  cardNo;
    
    // constructors
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    /*
     * Checks if the card numbers are equal or not
     * @return - true if card numbers are equal, otherwise false
     */
    public boolean equals( Card c)
    {
        return (c.cardNo == this.cardNo);
    }
    
    /*
     * Compares cards with each other
     * @return - difference between faceValues of Cards
     */
    public int compareTo( Card c)
    {
        return this.getFaceValue() - c.getFaceValue();
    }
}