package classes;
import java.util.ArrayList;

/*
 * XHTMLFilteredReader
 * @author U�ur Erdem Seyfi
 * @version 03.03.2019
 */

public class XHTMLFilteredReader extends HTMLFilteredReader{
    
    /*
     * Default constructor
     * @param - adress adress of the link
     */
    public XHTMLFilteredReader(String adress){
        super(adress);
    }
    
    /*
     * Content ratio
     * @return - html/total ratio
     */
    public String contentRatio(){
        int total = super.getUnfilteredPageContents().length();
        int text = super.getPageContents().length();
        int html = total - text;
        
        String s = (html + "/" + total + " of the page is html ");
        return s;
    }
    
    /*
     * Method that extracts links
     * @return - links
     */
    public ArrayList getLinks(){
        ArrayList<String> links = new ArrayList<String>();
        
        String s = super.getUnfilteredPageContents();
        
        int index = s.indexOf("href=");
        while(index >= 0 && index < s.length() ){
             s = s.substring( index + "href=".length(), s.length() );
             links.add( s.substring( 0, s.indexOf('>') ) );
             index = s.indexOf("href=");
         }
        
        return links;
    }
}