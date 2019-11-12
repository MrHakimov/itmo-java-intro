package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:49:07
 */

public class And extends AbstractBinaryOperation {
    public And(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x & y;
    }
}
