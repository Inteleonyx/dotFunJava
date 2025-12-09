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
public class ThisExpression implements Expression {
    public final Token keyword;

    public ThisExpression(Token keyword) {
        this.keyword = keyword;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitThisExpression(this);
    }
}
