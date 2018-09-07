/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionParts;

/**
 *
 * @author CJDB
 */
public class ExponentPart extends OpperationPart{

    public ExponentPart() {
        this.precedence = 0;
    }

    /**
     *
     * @param a base
     * @param b exponent
     * @return a^b the product
     */
    @Override
    public ValuePart action(double a, double b) {
        return new NumberPart(Math.pow(a, b));
    }
    
}
