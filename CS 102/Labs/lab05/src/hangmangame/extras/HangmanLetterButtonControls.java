package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.hangman.*;

/*
 * Panel for letter buttons
 * @author Uður Erdem Seyfi
 * @version 13.04.2019
 */

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView{
    
    // properties
    HangmanModel hangman;
    
    /*
     * Default constructor
     */
    public HangmanLetterButtonControls(HangmanModel h){
        super( h.getAllLetters());
        this.hangman = h;
    }
    
    /*
     * Method that updates the view of panel
     * @param hangman object
     */
    public void updateView(Hangman h){
        String usedLetters = h.getUsedLetters();
        
        if( h.isGameOver() ){
            // If the game is over dont let the user to press buttons
            setEnabledAll( false);
        } else{
            // If the game is not over then dont let the user press already used buttons
            setEnabledAll( true);
            setDisabled( usedLetters);
        }
    }
    
}