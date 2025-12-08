package org.dotfun.ast.expression;

import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;
import org.dotfun.lexer.Token;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class PostfixUnaryExpression implements Expression {
    public final Expression operand;
    public final Token op;

    public PostfixUnaryExpression(Token op, Expression operand) {
        this.op = op;
        this.operand = operand;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitPostfixUnary(this);
    }
}
