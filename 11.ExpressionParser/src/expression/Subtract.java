package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:57:21
 */

public class Subtract extends AbstractBinaryOperation {
    public Subtract(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x - y;
    }
}
