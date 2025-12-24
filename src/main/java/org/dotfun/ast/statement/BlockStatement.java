package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class BlockStatement implements Statement {
    public final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitBlock(this);
    }
}
