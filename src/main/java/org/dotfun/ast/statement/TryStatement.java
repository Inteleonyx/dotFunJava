package org.dotfun.ast.statement;

import org.dotfun.ast.Statement;
import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class TryStatement implements Statement {
    public final BlockStatement tryBlock;
    public final String errorName;
    public final BlockStatement catchBlock;
    public final BlockStatement finallyBlock; // pode ser null

    public TryStatement(
            BlockStatement tryBlock,
            String errorName,
            BlockStatement catchBlock,
            BlockStatement finallyBlock
    ) {
        this.tryBlock = tryBlock;
        this.errorName = errorName;
        this.catchBlock = catchBlock;
        this.finallyBlock = finallyBlock;
    }

    @Override
    public <R> R accept(StatementVisitor<R> visitor) {
        return visitor.visitTry(this);
    }
}
