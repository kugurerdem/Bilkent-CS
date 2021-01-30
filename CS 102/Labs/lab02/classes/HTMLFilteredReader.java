package classes;

/*
 * HTMLFilteredReader
 * @author U�ur Erdem Seyfi
 * @version 03.03.2019
 */

public class HTMLFilteredReader extends MySimpleURLReader{
    
    /*
     * Default constructor
     * @param - adress adress of the link
     */
    public HTMLFilteredReader(String adress){
        super(adress);
    }
    
    /*
     * @return - page contents without filtering
     */
    public String getUnfilteredPageContents(){
        return super.getPageContents();
    }
    
    /*
     * @return - return page contents without html tags
     * @override
     */
    public String getPageContents(){
        String s = super.getPageContents();
        String new_s = "";
        boolean isTag = false;
        
        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) == '<' ){
                isTag = true;
            } else if( s.charAt(i) == '>'){
                isTag = false;
            } else if( !isTag ){
                new_s = new_s + s.charAt(i);
            }
        }
        
        return new_s;
    }
    
}