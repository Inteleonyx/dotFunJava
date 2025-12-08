package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.AbstractMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class FunctionStatement implements Statement {
    private final String name;
    private final boolean isAsync;
    private final boolean isOverride;
    private final List<AbstractMap.SimpleEntry<String, Optional<String>>> params;
    private final Optional<String> returnType;
    private final List<Statement> body;

    public FunctionStatement(
            String name,
            boolean isAsync,
            boolean isOverride,
            List<AbstractMap.SimpleEntry<String, Optional<String>>> params,
            Optional<String> returnType,
            List<Statement> body
    ) {
        this.name = name;
        this.isAsync = isAsync;
        this.isOverride = isOverride;
        this.params = params;
        this.returnType = returnType;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public boolean isAsync() {
        return isAsync;
    }

    public boolean isOverride() {
        return isOverride;
    }

    public List<AbstractMap.SimpleEntry<String, Optional<String>>> getParams() {
        return params;
    }

    public Optional<String> getReturnType() {
        return returnType;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitFunction(this);
    }
}
