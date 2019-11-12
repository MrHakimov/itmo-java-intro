package expression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class Variable implements NewExpression {
    private String name;

    public Variable(String newName) {
        name = newName;
    }

    public strictfp double evaluate(double x) {
        return x;
    }

    public int evaluate(int x) {
        return x;
    }

    public int evaluate(int x, int y, int z) {
        if (name.equals("x"))
            return x;
        else if (name.equals("y"))
            return y;
        else
            return z;
    }
}