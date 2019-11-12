package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:52:44
 */

public class Negate extends AbstractUnaryOperation {
    public Negate(TripleExpression operand) {
        super(operand);
    }

    protected int calculate(int x) {
        return -x;
    }
}
