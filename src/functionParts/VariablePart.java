package functionParts;

/**
 *
 * @author CJDB
 */
public class VariablePart extends ValuePart {
    
    protected char var;
    
    public VariablePart(char var) {
        this.var = var;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public char getVar() {
        return this.var;
    }
    
    @Override
    public boolean equals(Object other) {
        if(super.equals(other)) {
            if(((VariablePart)other).var == this.var) {
                return true;
            }
        }
        return false;
    }
}
