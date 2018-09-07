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
        FunctionParser parsly = new FunctionParser("xy + 4(x/2)");//example function
        
        double[] vars = {4, 2};
        System.out.println(parsly.evaluate(vars));
        //System.out.println(parsly.evaluate());
    }
    
}
