package functionParts;

/**
 *
 * @author CJDB
 */
public class MultiplicationPart extends OpperationPart{

    public MultiplicationPart() {
        this.precedence = 1;
    }

    /**
     *
     * @param a
     * @param b
     * @return a*b the product
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(a * b);
    }
    
}
