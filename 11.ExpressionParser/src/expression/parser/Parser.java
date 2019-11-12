package expression.parser;

import expression.TripleExpression;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.12.2018 15:35:37
 */

public interface Parser {
    TripleExpression parse(String expression);
}
