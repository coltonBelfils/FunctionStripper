package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class OpperationPart extends FunctionPart{
    
    protected int precedence;
    
    public OpperationPart() {
        
    }
    
    public abstract ValuePart action(double a, double b);
    
    public int getPrecedence() {
        return this.precedence;
    }
}
