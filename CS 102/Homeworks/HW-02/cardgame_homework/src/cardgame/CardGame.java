package cardgame;

import java.util.ArrayList;

/*
 * CardGame class
 * @author Uður Erdem Seyfi
 * @version 06.03.2019
 */
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // set of players
        players = new ArrayList<Player>();
        
        // players joined the game
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        // created a new fullPack and then shuffled it
        fullPack = new Cards(true);
        fullPack.shuffle();
        
        // distribute cards to the players
        for(int i = 0; i < fullPack.NOOFCARDSINFULLPACK; i++){
            players.get( i % players.size() ).add( fullPack.getTopCard() );
        }
        
        // initial values
        turnOfPlayer = 0;
        roundNo = 0;
        scoreCard = new ScoreCard(players);
        
        cardsOnTable = new Cards[ players.size() ];
        for(int i = 0; i < cardsOnTable.length; i++){
            cardsOnTable[i] = new Cards(false);
        }
    }
    
    /*
     * @param player
     * @param card 
     * @return if player played the card return true otherwise false
     */
    public boolean playTurn( Player p, Card c)
    {
        if( isTurnOf(p) ){
            scoreCard.update(turnOfPlayer, c.getFaceValue() );
            cardsOnTable[turnOfPlayer].addTopCard(c);
            turnOfPlayer = (turnOfPlayer + 1) % players.size();
            roundNo++;
            
            return true;
        }
        
        return false;
    }
    
    /*
     * @param - player
     * @return the statement that turn is the player's turn
     */
    public boolean isTurnOf( Player p)
    {
        return players.get(turnOfPlayer) == p;
    }
    
    public boolean isGameOver()
    {
        return roundNo >= fullPack.NOOFCARDSINFULLPACK;
    }
    
    /*
     * @param  - playerNumber
     * @return - score of the player
     */
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        // ToDo
        return "Not yet implemented";
    }
    
    /*
     * @return - roundNo
     */
    public int getRoundNo()
    {
        return roundNo;
    }
    
    /*
     * @return -- turnOfPlayerNo
     */
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    /*
     * @return - winners of the game 
     */
    public Player[] getWinners()
    {
        int[] indexWinners = scoreCard.getWinners();
        Player[] winners = new Player[indexWinners.length];
        for(int i = 0; i < winners.length; i++){
            winners[i] = players.get(indexWinners[i]);
        }
        return winners;
    }
    
    /*
     * @return - string information of the scoreCard
     */
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}