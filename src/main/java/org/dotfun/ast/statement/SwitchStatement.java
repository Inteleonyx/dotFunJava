package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

import java.util.List;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class SwitchStatement implements Statement {
    public final Expression expression;
    public final List<SwitchCase> cases;
    public final List<Statement> defaultBody;

    public SwitchStatement(
            Expression expression,
            List<SwitchCase> cases,
            List<Statement> defaultBody
    ) {
        this.expression = expression;
        this.cases = cases;
        this.defaultBody = defaultBody;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitSwitch(this);
    }
}
