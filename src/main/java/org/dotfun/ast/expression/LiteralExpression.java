package org.dotfun.ast.expression;

import lombok.Getter;
import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

@Getter
public class LiteralExpression implements Expression {
    public final Object value;

    public LiteralExpression(Object value, int line) {
        this.value = value;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitLiteralExpression(this);
    }
}
