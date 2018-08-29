package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class FunctionPart {
    
    boolean completed = false;
    int rangeStart;
    int rangeEnd;
    
    public FunctionPart(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }
    
    public abstract double action();
    
    public boolean completed() {
        return completed;
    }
    
    public void complete() {
        completed = true;
    }
}
