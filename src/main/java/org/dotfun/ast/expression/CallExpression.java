package org.dotfun.ast.expression;

import lombok.Getter;
import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;
import org.dotfun.lexer.Token;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

@Getter
public class CallExpression implements Expression {
    public final Expression callee;
    public final Token token;
    public final List<Expression> arguments;

    public CallExpression(Expression callee, Token token, List<Expression> arguments) {
        this.callee = callee;
        this.token = token;
        this.arguments = arguments;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitCallExpression(this);
    }
}
