package org.dotfun.ast;

import org.dotfun.ast.visitor.ExpressionVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */
public interface Expression {
    <R> R accept(ExpressionVisitor<R> visitor);
}
