package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class EnumStatement implements Statement {
    public final String name;
    public final List<String> values;

    public EnumStatement(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitEnum(this);
    }
}
