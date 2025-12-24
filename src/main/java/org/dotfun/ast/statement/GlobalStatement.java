package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;
import org.dotfun.lexer.Token;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class GlobalStatement implements Statement {
    public final Token name;
    public final Expression initializer;

    public GlobalStatement(Token name, Expression initializer) {
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitGlobal(this);
    }
}
