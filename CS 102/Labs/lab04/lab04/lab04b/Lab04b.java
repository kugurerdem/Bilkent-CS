import shapes.*;
import javax.swing.*;
import java.awt.*;

/*
 * Lab04b - Balloons Game
 * @author U�ur Erdem Seyfi
 * @version 31.03.2019
 */

public class Lab04b{
    
    // static variables
    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    
    /*
     * main method to run the program
     */
    public static void main(String[] args){
        // declaring variables
        JFrame frame;
        BalloonsGamePanel gamePanel;
        
        // creating frame
        frame = new JFrame("Lab04b - Balloons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // creating gamePanel
        gamePanel = new BalloonsGamePanel();
        gamePanel.setPreferredSize( new Dimension(WIDTH, HEIGHT) );
        
        // adding gamePanel to frame and setting frame to be visible
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
    }
}