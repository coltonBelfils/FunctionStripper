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
    
    LinkedList<FunctionPart> tokens = new LinkedList();
    LinkedList<OpperationPart> stack = new LinkedList<>();
    LinkedList<FunctionPart> output = new LinkedList<>();
        /*
        100. Parenthises
        0. Exponents
        1. Multi/Div
        2. Add/Sub
        */
    
    public FunctionParser(final String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty");
        }
        this.input = input;
        
        this.tokenize();
        
        this.shuntingYard();
    }
    
    private void tokenize() {
        for(int i = 0; i < this.input.length(); i++) {
            if(Character.isDigit(this.input.charAt(i))) {
                String readNum = "";
                for(; input.length() > i && Character.isDigit(this.input.charAt(i)); i++) {
                    readNum += String.valueOf(this.input.charAt(i));
                }
                i--;
                if(tokens.size() > 1 && tokens.get(tokens.size() - 1).getClass().getSimpleName().equals(ParenTailPart.class.getSimpleName())) {
                    tokens.addLast(new MultiplicationPart());
                    tokens.addLast(new ValuePart(Double.valueOf(readNum)));
                } else {
                    tokens.addLast(new ValuePart(Double.valueOf(readNum)));
                }
            } else if(Character.isWhitespace(this.input.charAt(i))) {
                
            }else if(Character.valueOf(this.input.charAt(i)).equals('*')) {
                tokens.addLast(new MultiplicationPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('/')) {
                tokens.addLast(new DivisionPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('+')) {
                tokens.addLast(new AddPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('-')) {
                tokens.addLast(new SubtractPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('(')) {
                tokens.addLast(new ParenHeadPart());
                if(tokens.size() > 1 && tokens.get(tokens.size() - 2).getClass().getSimpleName().equals(ValuePart.class.getSimpleName())) {
                    tokens.addIndex(tokens.size() - 2, new MultiplicationPart());
                }
            } else if(Character.valueOf(this.input.charAt(i)).equals(')')) {
                tokens.addLast(new ParenTailPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('^')) {
                tokens.addLast(new ExponentPart());
            } else if(Character.valueOf(this.input.charAt(i)).equals('%')) {
                tokens.addLast(new ModPart());
            }
        }
    }
    
    private void shuntingYard() {
        for(FunctionPart x : tokens) {
            if(x.getClass().getSimpleName().equals(ValuePart.class.getSimpleName())) {
                output.addLast(x);
            } else if(x.getClass().getSimpleName().equals(ParenHeadPart.class.getSimpleName())) {
                stack.addLast((OpperationPart)x);
            } else if(x.getClass().getSimpleName().equals(ParenTailPart.class.getSimpleName())) {
                while(!stack.isEmpty() && !stack.getLast().getClass().getSimpleName().equals(ParenHeadPart.class.getSimpleName())) {
                    output.addLast(stack.getLast());
                    stack.removeLast();
                }
                stack.removeLast();
            } else {
                while(!stack.isEmpty() && stack.getLast().getPrecedence() < ((OpperationPart)x).getPrecedence()) {
                    output.addLast(stack.getLast());
                    stack.removeLast();
                }
                stack.addLast(((OpperationPart)x));
            }
        }
        while(!stack.isEmpty()) {
            output.addLast(stack.getLast());
            stack.removeLast();
        }
    }
    
    public double evaluate() {
        while(output.size() > 1) {
            int i;
            for(i = 0; !output.get(i).getClass().getSuperclass().getSimpleName().equals(OpperationPart.class.getSimpleName()); i++);
            ValuePart temp = ((OpperationPart)output.get(i)).action(((ValuePart)output.get(i - 2)).action(), ((ValuePart)output.get(i - 1)).action());
            output.removeIndex(i);
            output.removeIndex(i - 1);
            output.removeIndex(i - 2);
            output.addIndex(i - 2, temp);
        }
        return ((ValuePart)output.getFirst()).action();
    }
}
