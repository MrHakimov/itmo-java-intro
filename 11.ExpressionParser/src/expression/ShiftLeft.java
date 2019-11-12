package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 15.12.2018 16:15:09
 */

public class ShiftLeft extends AbstractBinaryOperation{
    public ShiftLeft(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x << y;
    }
}
