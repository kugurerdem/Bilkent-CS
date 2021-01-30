package classes;
import cs1.SimpleURLReader;

/*
 * MySimpleURLReader
 * @author Uður Erdem Seyfi
 * @version 03.03.2019
 */

public class MySimpleURLReader extends SimpleURLReader{
    // properties
    String url;
    String name;
    
    /*
     * Default constructor
     * @param - adress adress of the link
     */
    public MySimpleURLReader(String adress){
        super(adress);
        url = adress;
        
        name = "";
        for(int i = 0; i < url.length(); i++){
            char ch = url.charAt(i);
            if( i != url.length() - 1 && ch == '/'){
                name = "";
            } else{
                name = name + ch;
            }
        }
        
    }
    
    /*
     * method that returns url
     * @return - url
     */
    public String getURL(){
        return url;
    }
    
    /*
     * method that returns name
     * @return - name
     */
    public String getName(){
        return name;
    }
    
    /*
     * method that returns content without null
     * @return - content of the page
     * @override
     */
    public String getPageContents(){
        String contents = super.getPageContents();
        return contents.substring( "null".length(), contents.length()-1);
    }
    
}