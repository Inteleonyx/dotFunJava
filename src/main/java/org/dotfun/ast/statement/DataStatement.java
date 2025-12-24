package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class DataStatement implements Statement {
    public final String name;
    public final List<String> fields;

    public DataStatement(String name, List<String> fields) {
        this.name = name;
        this.fields = fields;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitData(this);
    }
}
