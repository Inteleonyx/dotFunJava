package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ClassStatement implements Statement {
    public final String name;
    public final String superClass; // pode ser null
    public final List<Statement> members;

    public ClassStatement(String name, String superClass, List<Statement> members) {
        this.name = name;
        this.superClass = superClass;
        this.members = members;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitClass(this);
    }
}
