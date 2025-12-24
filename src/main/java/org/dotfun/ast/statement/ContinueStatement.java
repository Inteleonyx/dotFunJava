package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ContinueStatement implements Statement {
    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitContinue(this);
    }
}
