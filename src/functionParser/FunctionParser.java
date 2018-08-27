package functionParser;

/**
 *
 * @author CJDB
 */
public class FunctionParser {
    
    String input;
    public FunctionParser(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty");
        }
        this.input = input;
    }
}
