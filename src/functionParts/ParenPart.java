package functionParts;

/**
 *
 * @author CJDB
 */
public class ParenPart extends OpperationPart {

    boolean completed = false;
    
    public ParenPart(double firstNum, int rangeStart, int rangeEnd) {
        super(firstNum, rangeStart, rangeEnd);
    }

    @Override
    public double action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
