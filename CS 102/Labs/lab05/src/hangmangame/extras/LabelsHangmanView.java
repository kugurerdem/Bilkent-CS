package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.hangman.*;

/*
 * Panel that contains label information for game
 * @author U�ur Erdem Seyfi
 * @version 15.04.2019
 */

public class LabelsHangmanView extends JPanel implements IHangmanView{
    // properties
    HangmanModel hangman;
    JLabel numOfIncorrectTries;
    JLabel knownSoFar;
    JLabel usedLetters;
    JLabel hasLost;
    
    /*
     * Default constructor
     * @param HangmanModel
     */
    public LabelsHangmanView(HangmanModel h){
        // assigning values to properties
        this.hangman = h;

        // some properties of panel
        setBackground(Color.GREEN);
        setLayout( new GridLayout(4, 1) );
        
        // creating labels
        this.numOfIncorrectTries = new JLabel();
        this.knownSoFar = new JLabel();
        this.usedLetters = new JLabel();
        this.hasLost = new JLabel();
        
        // setting alignment of the labels to center
        this.numOfIncorrectTries.setHorizontalAlignment(JLabel.CENTER);
        this.knownSoFar.setHorizontalAlignment(JLabel.CENTER);
        this.usedLetters.setHorizontalAlignment(JLabel.CENTER);
        this.hasLost.setHorizontalAlignment(JLabel.CENTER);
        
        // update the view
        this.updateView(this.hangman);
        
        // add all labels to the panel
        add( this.numOfIncorrectTries);
        add( this.knownSoFar);
        add( this.usedLetters);
        add( this.hasLost);
    }
    
    /*
     * Method that updates the view of panel
     * @param hangman object
     */
    @Override
    public void updateView(Hangman h){
        this.numOfIncorrectTries.setText( " Number of incorrect tries : " + h.getNumOfIncorrectTries());
        this.knownSoFar.setText( " " + h.getKnownSoFar() );
        this.usedLetters.setText( " Used letters : " + h.getUsedLetters() );
        this.hasLost.setText( h.hasLost() ? "lost" : "not lost" );
    }
    
}