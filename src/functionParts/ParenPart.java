package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class ParenPart extends OpperationPart {

    public ParenPart() {
        super(true);
        this.precedence = 100;
    }
    
}
