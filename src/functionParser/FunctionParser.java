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
    LinkedList<FunctionPart> partsList = new LinkedList<>();
        /*
        0. Parenthises
        1. Exponents
        2. Multi/Div
        3. Add/Sub
        This may need to change at some point
        */
    
    public FunctionParser(final String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty");
        }
        this.input = input;
        
        String readNum = "";
        int parenCount = 0;
        for(int i = 0; i < this.input.length(); i++) {
            if(Character.isDigit(this.input.charAt(i))) {//number input needs work add loop
                int start = i;
                for(; Character.isDigit(this.input.charAt(i)); i++) {
                    readNum += String.valueOf(this.input.charAt(i));
                }
                this.partsList.add(new ValuePart(Double.valueOf(readNum), start, i));
            } else if(Character.isWhitespace(this.input.charAt(i))){
                //skip to next line
            } else if(this.input.charAt(i) == '(') {
                boolean capFound = false;
                for(int h = 0; h < input.length(); h++) {
                    if(this.input.charAt(h) == '(') {
                        parenCount++;
                    }else if(this.input.charAt(h) == ')') {
                        if(parenCount == 0) {
                            this.partsList.add(new ParenPart(Double.valueOf(readNum), i, h));
                            capFound = true;
                        } else {
                            parenCount--;
                            if(parenCount < 0) {
                                throw new InvalidFormatException("found ) without a matching (");
                            }
                        }
                    }
                }
                if(capFound == false) {
                    throw new InvalidFormatException("found ( without a matching )");
                }
            } else if(this.input.charAt(i) == '+' || this.input.charAt(i) == '-') {
                if(this.input.charAt(i) == '+') {
                    this.partsList.add(new AddPart(Double.valueOf(readNum)));
                } else {
                    this.partsList.add(new SubtractPart(Double.valueOf(readNum)));
                }
            } else if(this.input.charAt(i) == '*' || this.input.charAt(i) == '/') {
                if(this.input.charAt(i) == '*') {
                    this.partsList.add(new MultiplicationPart(Double.valueOf(readNum)));
                } else {
                    this.partsList.add(new DivisionPart(Double.valueOf(readNum)));
                }
            }
        }
    }
}
