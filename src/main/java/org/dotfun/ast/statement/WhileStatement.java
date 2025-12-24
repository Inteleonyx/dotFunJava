package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class WhileStatement implements Statement {
    public final Expression condition;
    public final Statement body;

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitWhile(this);
    }
}
