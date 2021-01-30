package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.hangman.*;

/*
 * TextField for getting guesses from the user
 * @author Uður Erdem Seyfi
 * @version 15.04.2019
 */

public class TextFieldControlPanel extends JPanel{
    // properties
    HangmanModel hangman;
    JTextField textField;
    
    /*
     * Default constructor
     * @param hangman
     */
    public TextFieldControlPanel(HangmanModel h){
        // assigning values to properties
        this.hangman = h;
        this.textField = new JTextField( 10);
        this.setPreferredSize( new Dimension(100, 50) );
        setBackground( Color.BLACK);
        
        // Action listener for textField
        textField.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JTextField src = (JTextField) e.getSource(); // textField object
                
                String input = src.getText(); // text that has been entered
                for(int i = 0; i < input.length(); i++){
                    hangman.tryThis( input.charAt(i) );
                }
                
                src.setText("");
            }
        });
        
        // add textField to the panel
        this.add(textField);
       
    }
}