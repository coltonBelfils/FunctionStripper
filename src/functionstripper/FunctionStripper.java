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

        if (args.length == 1) {
            FunctionParser parsly = new FunctionParser(args[0]);

            System.out.println(parsly.evaluate());
        } else if (args.length > 1) {
            double[] vars = new double[args.length - 1];
            FunctionParser parsly = new FunctionParser(args[0]);
            for(int i = 1; i < args.length; i++) {
                vars[i - 1] = Double.valueOf(args[i]);
            }

            System.out.println(parsly.evaluate(vars));
        } else {
            FunctionParser parsly = new FunctionParser("1-2-3");//example function

            //double[] vars = {4, 2};
            //System.out.println(parsly.evaluate(vars));
            System.out.println(parsly.evaluate());
        }
    }
}
