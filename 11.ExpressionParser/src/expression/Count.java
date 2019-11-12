package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:50:51
 */

public class Count extends AbstractUnaryOperation {
    public Count(TripleExpression operand) {
        super(operand);
    }

    protected int calculate(int x) {
        return Integer.bitCount(x);
    }
}
