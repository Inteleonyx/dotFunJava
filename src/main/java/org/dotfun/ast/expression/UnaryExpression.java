package org.dotfun.ast.expression;

import lombok.Getter;
import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;
import org.dotfun.lexer.Token;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

@Getter
public class UnaryExpression implements Expression {
    public final Token op;
    public final Expression value;

    public UnaryExpression(Token op, Expression value) {
        this.op = op;
        this.value = value;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitUnaryExpression(this);
    }
}
