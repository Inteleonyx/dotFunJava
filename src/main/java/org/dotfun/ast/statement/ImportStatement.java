package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ImportStatement implements Statement {
    public final String path;

    public ImportStatement(String path) {
        this.path = path;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitImport(this);
    }
}
