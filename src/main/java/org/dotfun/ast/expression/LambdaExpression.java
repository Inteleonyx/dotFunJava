package org.dotfun.ast.expression;

import lombok.Getter;
import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 08/12/2025
 * @project dotFunJava
 */

@Getter
public class LambdaExpression implements Expression {
    public final List<String> params;
    public final Object body;

    public LambdaExpression(List<String> params, Object body) {
        this.params = params;
        this.body = body;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitLambda(this);
    }
}
