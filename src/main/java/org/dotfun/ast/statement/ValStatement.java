package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;
import org.dotfun.lexer.Token;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ValStatement implements Statement {
    public final Token type;
    public final Expression initializer;

    public ValStatement(Token type, Expression initializer) {
        this.type = type;
        this.initializer = initializer;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitVal(this);
    }
}
