/**
 * @(#)Hangman.java
 *
 *
 * @ Deniz Kasap
 * @ Mohammad Elham Amin
 * @ Kaan Gürler
 * @ Batuhan Budak
 * @ Ali Kasım Çetinkaya
 * @ Celil Buğra Karacan
 * @ Kaan Uğuralp
 * @version 1.00 2019/2/11
 */


public class Hangman
{
    // properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private int numOfIncorrectTries;
    private int maxAllowedIncorrect;
    private StringBuffer knownSoFar;

    // constructor

    public Hangman()
       {
        // for number 2
    }

    // methods
    public tryThis()
    {
        // for number 3
    }
    public chooseSecretWord()
    {
        // for number 4
    }
    public boolean isGameOver()
    {
        return (maxAllowedIncorrect<=numOfIncorrectTries || knownSoFar.equals(secretWord));
    }
    public boolean hasLost()
    {
        if (this.isGameOver())
        {
            if (knownSoFar.equals(secretWord))
            {
                return false;
            }
            else if(maxAllowedIncorrect<=numOfIncorrectTries)
            {
                return true;
            }
        }
        return false;
    }
    // Getters
    public String getAllLetters()
    {
        return allLetters;
    }
    public String getUsedLetters()
    {
        return usedLetters;
    }
    public int getNumOfIncorrectTries()
    {
        return numOfIncorrectTries;
    }
    public int getMaxAllowedIncorrectTries()
    {
        return maxAllowedIncorrectTries;
    }
    public String getKnownSoFar()
    {
        return knownSoFar;
    }


}