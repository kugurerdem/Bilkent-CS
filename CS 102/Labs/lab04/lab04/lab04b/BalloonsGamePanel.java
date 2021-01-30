import shapes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

/*
 * BalloonsGamePanel
 * @author Uður Erdem Seyfi
 * @version 31.03.2019
 */

public class BalloonsGamePanel extends JPanel{
    // constant properties
    static final int INTERVAL = 250; // time interval for timer object
    static final int INITIAL_BALLOON_COUNT = 25; // number of balloons will be initialized
    static final int TIME_LIMIT = 10; // seconds
    
    // properties
    private ShapeContainer balloons; // balloon container
    private Timer timer; // timer object
    private int points;
    private double elapsedTime;
    private JLabel label;
    private boolean gameOver;
    
    private MyMouseListener mouseListener;
    
    /*
     * Default constructor
     */
    public BalloonsGamePanel(){        
        start();
    }
    
    public void start(){
        // Setting background color
        setBackground(Color.GREEN);
        
        // Some of the game properties
        balloons = new ShapeContainer();
        points = 0;
        elapsedTime = 0;
        gameOver = false;
        
        // Creating label
        label = new JLabel("Points : " + points + " Elapsed time : " + (int) elapsedTime);
        this.add(label);
        
        // Initializing balloons
        for(int i = 0; i < INITIAL_BALLOON_COUNT; i++){
            int randomX = (int) (Math.random() * Lab04b.WIDTH);
            int randomY = (int) (Math.random() * Lab04b.HEIGHT);
            balloons.add( new Balloon(randomX, randomY) );
        }
        
        // MouseActionListener
        mouseListener = new MyMouseListener();
        addMouseListener( mouseListener );
        
        // Setting timer
        timer = new Timer(INTERVAL, new TimerListener() );
        
        timer.start();
    }
    
    /*
     * MyMouseListener inner class for mouse listener
     */
    class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            // get the mouse position from the user
            Point position = e.getPoint();
            int x = (int) position.getX();
            int y = (int) position.getY();
            
            // sellect all the balloons contains that position and then remove them
            System.out.println("x : " + x + " y : " + y);
            int balloonSelected = balloons.selectAllAt(x, y);
            balloons.remove();
            
            // add the number of ballons that you pin to the points
            points = points + balloonSelected;
        }
    }
    
    
    /*
     * TimerListener inner class for timer action listener
     */
    class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // change the label information
            elapsedTime = elapsedTime + ((double) INTERVAL / (double) 1000);
            label.setText("Points : " + points + " Elapsed time : " + (int)(elapsedTime) );
            
            // Grow each balloon's size
            Iterator balloonsIterator = balloons.iterator();
            while(balloonsIterator.hasNext() ){
                Balloon balloon = (Balloon) balloonsIterator.next();
                balloon.grow();
            }
            
            // Add new ballon if the number of them is less then 15
            if( balloons.size() < 15 ){
                Dimension a = getSize();
                int randomX = (int) (Math.random() * a.getWidth() );
                int randomY = (int) (Math.random() * a.getHeight() );
                balloons.add( new Balloon(randomX, randomY) );
            }
            
            // Check if the time is over
            if( elapsedTime >= TIME_LIMIT){
                gameOver = true;
            }
            
            // Check if the game is over
            if( gameOver ){
                timer.stop();
                removeMouseListener(mouseListener);
                removeAll();
                
                int finish = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Play Again", "Game Over", 0);
                if( finish == 0 ){
                    // restart the game
                    start();
                } else{
                    System.exit(0);
                }
            }
            
            // repaint the stuff
            repaint();
        }
    }
    
    /*
     * Overriden paintComponent method
     * @param g - graphics
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Iterator balloonsIterator = balloons.iterator();
        
        while( balloonsIterator.hasNext() ){
            Object balloon = balloonsIterator.next();
            ((Drawable)balloon).draw(g);
        }
    }
}