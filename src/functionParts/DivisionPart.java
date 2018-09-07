package functionParts;

/**
 *
 * @author CJDB
 */
public class DivisionPart extends OpperationPart{

    public DivisionPart() {
        this.precedence = 1;
    }

    /**
     *
     * @param a dividend: number being divided
     * @param b divisor: number dividing
     * @return a/b the quotient
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(a / b);
    }
    
}
