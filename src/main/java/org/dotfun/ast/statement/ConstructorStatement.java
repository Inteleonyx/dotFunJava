package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;
import org.dotfun.lexer.Token;

import java.util.AbstractMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class ConstructorStatement implements Statement {
    public final Token name;
    private final List<AbstractMap.SimpleEntry<String, Optional<String>>> params;
    public final List<Statement> body;

    public ConstructorStatement(Token name, List<AbstractMap.SimpleEntry<String, Optional<String>>> params, List<Statement> body) {
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitConstructor(this);
    }
}
