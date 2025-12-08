package org.dotfun.ast.expression;

import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class VariableExpression implements Expression {
    public final String name;
    public final String declaredType;

    public VariableExpression(String name, String declaredType) {
        this.name = name;
        this.declaredType = declaredType;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitVariableExpression(this);
    }
}
