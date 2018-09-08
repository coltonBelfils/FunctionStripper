package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class OpperationPart extends FunctionPart{
    
    protected int precedence;
    protected boolean leftAssociative;
    
    public OpperationPart(boolean leftAssociative) {
        this.leftAssociative = leftAssociative;
    }
    
    public abstract ValuePart action(double a, double b);
    
    public int getPrecedence() {
        return this.precedence;
    }
    
    public boolean isLeftAssociative() {
        return leftAssociative;
    }
}
