package functionParts;

/**
 *
 * @author CJDB
 */
public class ValuePart extends FunctionPart{

    private double value;
    
    public ValuePart(double value, int rangeStart, int rangeEnd) {
        super(rangeStart, rangeEnd);
        this.value = value;
    }
    
    @Override
    public double action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
