package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:51:24
 */

public class Divide extends AbstractBinaryOperation {
    public Divide(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x / y;
    }
}
