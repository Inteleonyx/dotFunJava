package org.dotfun.ast.expression;

import lombok.Getter;
import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

@Getter
public class InstanceOfExpression implements Expression {
    public final Expression value;
    public final String typeName;

    public InstanceOfExpression(Expression value, String typeName) {
        this.value = value;
        this.typeName = typeName;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitInstanceOf(this);
    }
}
