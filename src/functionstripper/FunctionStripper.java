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
        FunctionParser parsly = new FunctionParser("3(4^2) + (3%6) * 4");//example function
        
        System.out.println(parsly.evaluate());
    }
    
}
