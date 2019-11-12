package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:49:55
 */

public class Not extends AbstractUnaryOperation {
    public Not(TripleExpression operand) {
        super(operand);
    }

    protected int calculate(int x) {
        return ~x;
    }
}
