package expression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 14:50:19
 */

public class Const implements TripleExpression {
    private Number value;

    public Const(Number value) {
        assert value != null : "ERROR: Value of constant is null!";
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }
}
