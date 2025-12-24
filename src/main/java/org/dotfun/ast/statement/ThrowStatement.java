package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ThrowStatement implements Statement {
    public final Expression value;

    public ThrowStatement(Expression value) {
        this.value = value;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitThrow(this);
    }
}
