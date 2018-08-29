package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class OpperationPart extends FunctionPart{
    
    private double firstNum;
    
    public OpperationPart(double firstNum, int rangeStart, int rangeEnd) {
        super(rangeStart, rangeEnd);
        this.firstNum = firstNum;
    }
}
