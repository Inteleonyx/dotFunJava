package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class InterfaceStatement implements Statement {
    public final String name;
    public final List<FunctionStatement> methods;

    public InterfaceStatement(String name, List<FunctionStatement> methods) {
        this.name = name;
        this.methods = methods;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitInterface(this);
    }
}
