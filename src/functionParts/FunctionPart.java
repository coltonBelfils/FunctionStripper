package functionParts;

/**
 *
 * @author CJDB
 */
public abstract class FunctionPart {
    
    boolean completed = false;
    
    public abstract int action();
    
    public boolean completed() {
        return completed;
    }
    
    public void complete() {
        completed = true;
    }
}
