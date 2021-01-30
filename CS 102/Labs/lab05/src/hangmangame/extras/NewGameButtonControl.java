package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.hangman.*;

/*
 * Button that restarts the game
 * @author Uður Erdem Seyfi
 * @version 15.04.2019
 */

public class NewGameButtonControl extends JButton implements IHangmanView{
    // properties
    HangmanModel hangman;
    
    /*
     * Default constructor
     * @param HangmanModel 
     */
    public NewGameButtonControl(HangmanModel h){
        
        // assigning values to properties
        super("New Game");
        this.setEnabled(false);
        this.hangman = h; 
        
        // when this button is clicked, restart the game
        this.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                hangman.initNewGame();
                ((JButton)e.getSource()).setEnabled(false);
            }
        });
    }
    
    /*
     * Method that updates the view of panel
     * @param hangman object
     */
    public void updateView(Hangman h){
        if( this.hangman.isGameOver() ){
            this.setEnabled(true);
        }
    }
    
}