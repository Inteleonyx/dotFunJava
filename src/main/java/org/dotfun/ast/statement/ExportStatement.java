package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ExportStatement implements Statement {
    public final Statement declaration;

    public ExportStatement(Statement declaration) {
        this.declaration = declaration;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitExport(this);
    }
}
