package cardgame;
import java.util.ArrayList;

/*
 * ScoreCard - Maintains one integer score per player, for any number of players
 *             Caution: invalid playernumbers result in run-time exception!
 * @author Uður Erdem Seyfi
 * @version 06.03.2019
 */
public class ScoreCard
{
    // properties
    int[] scores;
    ArrayList<Player> players;
    
    // constructors
    
    /*
     * Default constructor
     * @param number of players
     */
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        players = new ArrayList<Player>();
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    /*
     * Second constructor
     * @param players
     */
    public ScoreCard(ArrayList<Player> p){
        this(p.size());
        players = p;
    }
    // methods
    
    /*
     * Method that returns the score of a player
     * @param no of player
     * @return his/her score
     */
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    /*
     * Method that adds the given amount to the score of player with given no
     * @param playerNo
     * @param amount
     */
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    /*
     * Method that returns string information about class
     * @return string information
     */
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            if(players.size() > 0)
                s = s + players.get(playerNo) + "\t" + scores[playerNo] + "\n";
            else
                s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    /*
     * method that returns the winners index
     * @return array of indexes of the winners
     */
    public int[] getWinners()
    {
        // finding the maximum score
        int max = scores[0];
        int[] indexes = new int[scores.length];
        int count = 0;
        
        for(int i = 1; i < scores.length; i++){
            if(max < scores[i]){
                max = scores[i];
                count = 0;
                indexes = new int[scores.length];
                indexes[count] = i;
            } else if(max == scores[i]){
                count++;
                indexes[count] = i;
            }
        }
        
        int[] arr = new int[count + 1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = indexes[i];
        }
        
        return arr;
    }
    
} // end class ScoreCard
