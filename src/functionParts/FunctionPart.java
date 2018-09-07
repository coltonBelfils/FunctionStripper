package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class FunctionPart {
    
    private final int hash;
    
    public FunctionPart() {
        hash = (int)(System.currentTimeMillis() * 100000);
    }
    
    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        } else if(other == this) {
            return true;
        } else if(!(other instanceof FunctionPart)) {
            return false;
        } else {
            return this.getClass().getSimpleName().equals(other.getClass().getSimpleName());
        }
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
