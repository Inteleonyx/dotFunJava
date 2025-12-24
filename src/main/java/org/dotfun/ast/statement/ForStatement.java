package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ForStatement implements Statement {
    public final Statement initializer;
    public final Expression condition;
    public final Expression increment;
    public final Statement body;

    public ForStatement(
            Statement initializer,
            Expression condition,
            Expression increment,
            Statement body
    ) {
        this.initializer = initializer;
        this.condition = condition;
        this.increment = increment;
        this.body = body;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitFor(this);
    }
}
