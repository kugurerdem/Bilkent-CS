package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.hangman.*;

/*
 * ActionListener for LetterButtonControls
 * @author Uður Erdem Seyfi
 * @version 13.04.2019
 */

public class HangmanLetterButtonsController implements ActionListener{
    // properties
    HangmanModel hangman;
    
    /*
     * Default constructor
     * @param hangman
     */
    public HangmanLetterButtonsController(HangmanModel h){
        this.hangman = h;
    }
    
    /*
     * When an action happens this method runs
     * @param ActionEvent
     */
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource(); // get the button
        char letter = source.getText().charAt(0); // get which letter is pressed
        
        this.hangman.tryThis( letter); // try the letter
        source.setEnabled( false); // disable the button
    }
}