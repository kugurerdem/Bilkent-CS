public class Print{
    
    // Method that prints table of powers of integers between a range (min, max)
    public static void TableOfPowers(int min, int max, int max_power){
        String result;
        int space;
        
        space = ( "[" + ( Methods.power(max, max_power) ) + "]" ).length() + 2;
        result = "";
        
        for(int i = min; i <= max; i++){
            String line;
            
            line = "";
            for(int j = 1; j <= max_power; j++){
                line = line + "[" + Methods.power(i, j) + "]";
                line = line + spaceFor( space - line.length()%space );
            }
            result = result + line + "\n";
        } 
        
        System.out.println(result);
    }
   
    // Method that prints table of powers of integers between a range (min, max)
    public static void TableOfFactorials(int min, int max, int cell_num){
        String result, line;
        int space, counter;
        
        space = ( "[" + max + "," + Methods.factorial(max) + "]" ).length() + 3;
        counter = 0;
        
        result = "";
        line = "";
        
        for(int i = min; i <= max; i++){
            line = line + "[" + i + "," + Methods.factorial(i) + "]";
            line = line + spaceFor( space - line.length()%space );
            
            if(++counter % cell_num == 0){
                line = line + "\n";
                result = result + line;
                line = "";
            }
        } 
        
        System.out.println( result );
    }
    
    // Method that prints table of Taylor series and its' compositions
    public static void TableOfSin(double x, int n){
        String result, line;
        int space, counter;
        
        System.out.println("\nThe Taylor table for given value : " + x + "\n");
        
        space = Math.max( ("" + Methods.sin(x, n)).length(), 10 );
        counter = 5;
        
        result = "n";
        result = result + spaceFor( space - result.length()%space );
        
        result = result + "comp_1";
        result = result + spaceFor( space - result.length()%space );
        
        result = result + "comp_2";
        result = result + spaceFor( space - result.length()%space );
                
        result = result + "comp_3";
        result = result + spaceFor( space - result.length()%space );
        
        result = result + "element";
        result = result + spaceFor( space - result.length()%space );
        
        result = result + "sin(x, n)";
        result = result + spaceFor( space - result.length()%space );
        
        result += "\n \n";
        
        
        double answer;
        
        answer = 0;
        
        for(int i = 0; i <= n; i++){
            double comp_1, comp_2, comp_3, element;
            
            line = "";
            comp_1 = Methods.power(-1, i);
            comp_2 = Methods.power(x, 2*i + 1);
            comp_3 = Methods.factorial(2*i + 1);
            
            element = (comp_1*comp_2) / comp_3;
            
            line = line + i;
            line = line + spaceFor( space - line.length()%space );
            line = line + String.format( "%.2f", comp_1);
            line = line + spaceFor( space - line.length()%space );
            line = line + String.format( "%.2f", comp_2);
            line = line + spaceFor( space - line.length()%space );
            line = line + String.format( "%.2f", comp_3);
            line = line + spaceFor( space - line.length()%space );
            line = line + String.format( "%.2f", element);
            line = line + spaceFor( space - line.length()%space );
            answer = answer + element;
            line = line + String.format( "%.8f", answer );
            
            
            result = result + line + "\n";
        }
        
        System.out.println(result);
    }
    
    // A Method that returns spaces for n times
    public static String spaceFor(int n){
        String str;
        str = "";
        
        for(int i = 0; i < n; i++){
            str = str + " ";
        }
        
        return str;
    }
    
}

