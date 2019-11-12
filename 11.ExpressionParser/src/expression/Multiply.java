package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:51:46
 */

public class Multiply extends AbstractBinaryOperation {
    public Multiply(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x * y;
    }
}
