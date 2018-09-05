package functionStripper;

import functionParser.FunctionParser;

/**
 *
 * @author CJDB
 */
public class FunctionStripper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FunctionParser parsly = new FunctionParser("5 * 4 + (4 / 2)");//example function
        
        System.out.println(parsly.evaluate());
    }
    
}
