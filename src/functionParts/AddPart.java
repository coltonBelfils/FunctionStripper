package functionParts;

/**
 *
 * @author CJDB
 */
public class AddPart extends OpperationPart{

    public AddPart() {
        this.precedence = 2;
    }

    /**
     *
     * @param a
     * @param b
     * @return a+b the sum
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(a + b);
    }
    
}
