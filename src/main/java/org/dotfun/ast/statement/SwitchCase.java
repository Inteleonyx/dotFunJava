package org.dotfun.ast.statement;

import org.dotfun.ast.Expression;
import org.dotfun.ast.Statement;

import java.util.List;

/**
 * @author Inteleonyx. Created on 24/12/2025
 * @project dotFunJava
 */

public class SwitchCase {
    public final Expression value;
    public final List<Statement> body;

    public SwitchCase(Expression value, List<Statement> body) {
        this.value = value;
        this.body = body;
    }
}
