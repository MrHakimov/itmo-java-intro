package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 15.12.2018 16:17:03
 */

public class ShiftRight extends AbstractBinaryOperation {
    public ShiftRight(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x >> y;
    }
}
