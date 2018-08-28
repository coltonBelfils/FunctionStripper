package functionParser;

import linkedList.LinkedList;
import functionParts.*;

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
        
        LinkedList<LinkedList> partsList = new LinkedList<>();
        /*
        0. Parenthises
        1. Exponents
        2. Multi/Div
        3. Add/Sub
        This may need to change at some point
        */
        for(int i = 0; i < 4; i++) {
            partsList.add(new LinkedList<FunctionPart>());
        }
        
        String readNum1 = "";
        String readNum2 = "";
        boolean numLast = false;
        for(int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                if((numLast == true || readNum1.isEmpty()) && !readNum2.isEmpty()) {
                    readNum1 += String.valueOf(input.charAt(i));
                    numLast = true;
                } else {
                    readNum2 += String.valueOf(input.charAt(i));
                    numLast = true;
                }
            } else if(Character.isWhitespace(input.charAt(i))){
                
            } else if(input.charAt(i) == '(') {
                partsList.get(0).add(new LinkedList<ParenPart>());
            }
        }
    }
}
