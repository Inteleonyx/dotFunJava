package org.dotfun.ast.expression;

import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;
import org.dotfun.lexer.Token;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class NewExpression implements Expression {
    public final Token className;
    public final List<Expression> arguments;

    public NewExpression(Token className, List<Expression> arguments) {
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitNewExpression(this);
    }
}
