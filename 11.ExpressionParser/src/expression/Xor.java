package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 15:03:08
 */

public class Xor extends AbstractBinaryOperation {
    public Xor(TripleExpression firstOperand, TripleExpression secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected int calculate(int x, int y) {
        return x ^ y;
    }
}
