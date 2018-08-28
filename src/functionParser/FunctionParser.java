package functionParser;

import linkedList.LinkedList;
import functionParts.*;
import exceptions.InvalidFormatException;

/**
 *
 * @author CJDB
 */
public class FunctionParser {
    
    String input;
    
    public FunctionParser(final String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty");
        }
        this.input = input;
        
        LinkedList<LinkedList<FunctionPart>> partsList = new LinkedList<>();
        /*
        0. Parenthises
        1. Exponents
        2. Multi/Div
        3. Add/Sub
        This may need to change at some point
        */
        partsList.add(new LinkedList<>());
        partsList.add(new LinkedList<>());
        partsList.add(new LinkedList<>());
        partsList.add(new LinkedList<>());
        
        String readNum1 = "";
        String readNum2 = "";
        boolean numLast = false;
        for(int i = 0; i < this.input.length(); i++) {
            if(Character.isDigit(this.input.charAt(i))) {//number input needs work add loop
                if((numLast == true || readNum1.isEmpty()) && !readNum2.isEmpty()) {
                    readNum1 += String.valueOf(this.input.charAt(i));
                    numLast = true;
                } else {
                    readNum2 += String.valueOf(this.input.charAt(i));
                    numLast = true;
                }
            } else if(Character.isWhitespace(this.input.charAt(i))){
                //skip to next line
            } else if(this.input.charAt(i) == '(') {
                partsList.get(0).add(new ParenPart(Double.valueOf(readNum1)));
            } else if(this.input.charAt(i) == '+' || this.input.charAt(i) == '-') {
                if(this.input.charAt(i) == '+') {
                    partsList.get(3).add(new AddPart(Double.valueOf(readNum1)));
                } else {
                    partsList.get(3).add(new SubtractPart(Double.valueOf(readNum1)));
                }
            } else if(this.input.charAt(i) == '*' || this.input.charAt(i) == '/') {
                if(this.input.charAt(i) == '*') {
                    partsList.get(3).add(new MultiplicationPart(Double.valueOf(readNum1)));
                } else {
                    partsList.get(3).add(new DivisionPart(Double.valueOf(readNum1)));
                }
            } else if(this.input.charAt(i) == ')') {
                if(partsList.get(0).isEmpty()) {
                    throw new InvalidFormatException("found ) without a matching (");
                }
                boolean foundMatch = false;
                for(int h = 0; partsList.get(0).get(h) != null && foundMatch == false; h++) {
                    if((!partsList.get(0).get(h).completed())) {
                        
                    }
                }
            }
        }
    }
}
