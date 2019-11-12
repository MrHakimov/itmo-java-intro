package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:48:39
 */

public class Add extends AbstractBinaryOperation {
    public Add(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x + y;
    }
}
