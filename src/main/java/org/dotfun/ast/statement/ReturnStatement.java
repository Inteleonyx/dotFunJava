package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ReturnStatement implements Statement {
    public final Expression value; // pode ser null

    public ReturnStatement(Expression value) {
        this.value = value;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitReturn(this);
    }
}
