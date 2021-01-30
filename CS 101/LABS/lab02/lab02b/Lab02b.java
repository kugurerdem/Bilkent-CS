import java.util.Scanner;

/**
 * __Lab02b: Applet___ 
 * @author __Uður Erdem Seyfi___
 * @version __16.10.2018
 */ 
import java.awt.Graphics;
import java.applet.Applet;

/**
 * An Applet!
 */
public class Lab02b extends Applet 
{
    
   public void paint( Graphics g)
   {
      g.drawString( "Hello...", 50, 50);
      g.drawRect( 25, 25, 100, 50);
   }
    
}