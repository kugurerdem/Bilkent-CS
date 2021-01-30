import classes.*;
import cs1.SimpleURLReader;
import java.util.ArrayList;

/*
 * Class for tests
 * @author Uður Erdem Seyfi
 * @version 03.03.2019
 */

public class Test{
    
    /*
     * Program execution
     */
    public static void main(String[] args){
        
        // Testing SimpleURLReader
        SimpleURLReader url_reader = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");
        
        System.out.println( url_reader.getPageContents() );
        System.out.println( url_reader.getLineCount() );
        
        // Testing MySimpleURLReader
        MySimpleURLReader my_reader = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~david/housman.txt");
        
        System.out.println( my_reader.getPageContents() );
        System.out.println( my_reader.getURL() );
        System.out.println( my_reader.getName() );
        
        // Testing HTMLFilteredReader
        MySimpleURLReader html_reader = new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/housman.htm");
        System.out.println( ((HTMLFilteredReader) html_reader).getUnfilteredPageContents() );
        System.out.println( ((HTMLFilteredReader) html_reader).getPageContents() );
        
        // Testing XHTMLFilteredReader
        MySimpleURLReader xhtml_reader = new XHTMLFilteredReader("http://www.cs.bilkent.edu.tr/~david/index.html");
        
        // Links
        System.out.println("Links that are in the page: \n");
        ArrayList links = ((XHTMLFilteredReader) xhtml_reader).getLinks();
        for(int i = 0; i < links.size(); i++){
            System.out.println( links.get(i) );
        }
        
        // Content ratio
        System.out.println( ((XHTMLFilteredReader) xhtml_reader).contentRatio() );
    }
    
    
}