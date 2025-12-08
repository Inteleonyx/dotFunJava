package org.dotfun.ast;

import org.dotfun.ast.visitor.StatementVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */
public interface Statement {
    <R> R accept(StatementVisitor<R> visitor);
}
