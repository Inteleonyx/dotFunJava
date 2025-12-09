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
public class SuperExpression implements Expression {
    public final Token keyword;
    public final Token method;

    public SuperExpression(Token keyword, Token method) {
        this.keyword = keyword;
        this.method = method;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitSuper(this);
    }
}
