import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Hangman class
 * @author Uður Erdem Seyfi and section01 students
 * @version 16/02/2019
 */

public class Hangman
{
    // properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;
    private StringBuffer knownSoFar;
    
    /*
     * Default constructor for Hangman class
     */
    public Hangman()
    {
        maxAllowedIncorrectTries = 6;
        numberOfIncorrectTries = 0;
        usedLetters = new StringBuffer();
        allLetters = new StringBuffer("abcdefghijklmnopqrstuwxyz");
        secretWord = new StringBuffer("");
        chooseSecretWord(System.getProperty("user.dir") + "\\test.txt");
        knownSoFar = new StringBuffer(secretWord.length());
        
        for (int i = 0; i < secretWord.length(); i++)
        {
            knownSoFar.append("*");
        }
    }
    
    /*
     * a method that checks if a given letter is already used or is valid etc.
     * @param letter - a letter
     * @return - -3 if game is over, -2 if it is already used, -1 if it is not valid, other wise the count of the letter
     */
    public int tryThis( char letter){
        int count;
        count = 0;
        
        // Checking if it is not already used
        for( int i = 0; i < getUsedLetters().length(); i++){
            if( getUsedLetters().charAt(i) == letter)
                return -2;
        }
        
        // Checking if the letter is valid
        boolean isValid = false;
        
        for( int i = 0; i < allLetters.length(); i++){
            if(allLetters.charAt(i) == letter){
                isValid = true;
            }
        }
        
        // If it is not valid then return -1
        if(!isValid){
            return -1;
        }
        
        // apend letter to the usedLetters
        usedLetters.append( letter);
        
        // count how many times letter appears in the word
        for( int i = 0; i < secretWord.length(); i++){
            if( secretWord.charAt(i) == letter){
                count = count + 1; 
                knownSoFar.setCharAt( i, letter);
            }
        }
        
        // if the letter is not in the word than increase the number of incorrect trials
        if( count == 0){
            numberOfIncorrectTries = numberOfIncorrectTries + 1;
        }
        
        // return -3 if the game is over
        if( isGameOver()){
            return -3;
        }
        
        // return how many times letter appears in the word
        return count;
    }
    
    
    /*
     * method that assigns a random value to secretWord
     */
    public void chooseSecretWord() {
        String[] words = {"awkward",
            "bagpipes",
            "banjo",
            "bungler",
            "croquet",
            "crypt",
            "dwarves",
            "fervid",
            "ivory",
            "jazzy",
            "jiffy",
            "jinx",
            "jukebox",
            "kayak",
            "kiosk",
            "klutz",
            "memento",
            "mystify",
            "gossip",
            "grogginess",
            "haiku",
            "haphazard",
            "hyphen",
            "iatrogenic",
            "icebox",
            "jogging",
            "joking",
            "jovial",
            "joyful",
            "juicy",
            "jukebox",
            "jumbo",
            "kayak",
            "kazoo",
            "keyhole",
            "khaki",
            "kilobyte",
            "kiosk",
            "kitsch",
            "kiwifruit",
            "klutz",
            "knapsack",
            "larynx",
            "lengths",
            "lucky",
            "luxury",
            "lymph",
            "marquis",
            "matrix",
            "megahertz",
            "microwave",
            "mnemonic",
            "mystify",
            "pizazz",
            "pneumonia",
            "polka",
            "pshaw",
            "psyche",
            "puppy",
            "puzzling",
            "quartz",
            "queue",
            "quips",
            "quixotic",
            "quiz",
            "quizzes",
            "quorum",
            "razzmatazz",
            "rhubarb",
            "woozy",
            "wristwatch",
            "wyvern",
            "xylophone",
            "yachtsman"};
        
        
        int randomIndex = (int)( words.length * Math.random() );
        secretWord = secretWord.delete(0, secretWord.length()).append( words[ randomIndex] );
    }
    
    /*
     * method that assigns a random value to secretWord from a given txt file
     * @param fileName - the location of file
     */
    public void chooseSecretWord(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                words.add(scan.next());
            }
            
            int randomIndex = (int)(words.size() * Math.random());
            secretWord = secretWord.delete(0, secretWord.length()).append( words.get(randomIndex) );
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }
    
    /*
     * returns true if game is over, otherwise returns false
     * @return - the statement that game is over
     */
    public boolean isGameOver()
    {
        return (maxAllowedIncorrectTries <= numberOfIncorrectTries || knownSoFar.toString().equals(secretWord.toString()));
    }
    
    /*
     * returns true if the player has lost, otherwise returns false
     * @return - the statement that player has lost
     */
    public boolean hasLost()
    {
        if (this.isGameOver())
        {
            if ( knownSoFar.toString().equals(secretWord.toString()) )
            {
                return false;
            }
            else if(maxAllowedIncorrectTries <= numberOfIncorrectTries)
            {
                return true;
            }
        }
        return false;
    }
    
    // Getters
     
    /*
     * @return - allLetters as string
     */
    public String getAllLetters()
    {
        return allLetters.toString();
    }
    
    /*
     * @return - usedLetters as string
     */
    public String getUsedLetters()
    {
        return usedLetters.toString();
    }
    
    /*
     * @return - numberOfIncorrectTries
     */
    public int getNumOfIncorrectTries()
    {
        return numberOfIncorrectTries;
    }
    
    /*
     * @return - maxAllowedIncorrectTries
     */
    public int getMaxAllowedIncorrectTries()
    {
        return maxAllowedIncorrectTries;
    }
    
    /*
     * @return - knownSoFar as string
     */
    public String getKnownSoFar()
    {
        return knownSoFar.toString();
    }
}