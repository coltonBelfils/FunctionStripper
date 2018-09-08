package functionParts;

/**
 *
 * @author CJDB
 */
public class ModPart extends OpperationPart {
    
    public ModPart() {
        super(true);
        this.precedence = 1;
    }

    /**
     *
     * @param a dividend: number getting divided
     * @param b divisor: number dividing
     * @return a%b the remainder
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(a % b);
    }
    
}
