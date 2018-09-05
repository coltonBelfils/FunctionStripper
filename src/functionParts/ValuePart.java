package functionParts;

/**
 *
 * @author CJDB
 */
public class ValuePart extends FunctionPart{
    
    double value;
    
    public ValuePart(double value) {
        this.value = value;
    }
    
    public double action() {
        return this.value;
    }
    
}
