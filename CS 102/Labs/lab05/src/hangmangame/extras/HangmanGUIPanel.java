package hangmangame.extras;

import cs102.hangman.HangmanModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author David Davenport & Uður Erdem Seyfi
 * @version 13.04.2019
 */
public class HangmanGUIPanel extends JPanel {
    // properties
    HangmanModel hm;
    TextFieldControlPanel textFieldCP;
    NewGameButtonControl newGameButton;
    LabelsHangmanView labelsHangmanView;
    GallowsHangmanView gallowsHangmanView;
    HangmanLetterButtonControls letterButtonControls;
    
    public HangmanGUIPanel( HangmanModel hm) {
        // Setting certain properties of the panel
        this.hm = hm;
        setPreferredSize( new Dimension( 700, 350) );
        setLayout( new BorderLayout() );
        // setBackground(Color.YELLOW);
        
        // NORT
        this.textFieldCP = new TextFieldControlPanel( this.hm );
        this.add( this.textFieldCP, BorderLayout.NORTH);
        
        // SOUTH
        this.newGameButton = new NewGameButtonControl( this.hm);
        this.add( this.newGameButton, BorderLayout.SOUTH);
        
        // WEST
        this.labelsHangmanView = new LabelsHangmanView( this.hm);
        this.add( this.labelsHangmanView, BorderLayout.WEST);
        
        
        // CENTER
        this.gallowsHangmanView = new GallowsHangmanView( this.hm);
        this.add( this.gallowsHangmanView, BorderLayout.CENTER);
        
        // EAST
        this.letterButtonControls = new HangmanLetterButtonControls( this.hm);
        this.letterButtonControls.addActionListener( new HangmanLetterButtonsController(this.hm) );
        this.add( this.letterButtonControls, BorderLayout.EAST);
        
        
        // add controls and views here...
        this.hm.addView( this.labelsHangmanView);
        this.hm.addView( this.gallowsHangmanView);
        this.hm.addView( this.newGameButton);
        this.hm.addView( this.letterButtonControls);
       
        
    }
    
}
