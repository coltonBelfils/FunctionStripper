package functionParts;

/**
 *
 * @author CJDB
 */
public class SubtractPart extends OpperationPart{

    public SubtractPart() {
        super(true);
        this.precedence = 2;
    }

    /**
     *
     * @param a
     * @param b
     * @return a-b the difference
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(a - b);
    }
    
}
