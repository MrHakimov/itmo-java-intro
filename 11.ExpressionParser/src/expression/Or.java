package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:54:46
 */

public class Or extends AbstractBinaryOperation {
    public Or(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x | y;
    }
}
