package org.dotfun.ast.visitor;

import org.dotfun.ast.expression.*;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */
public interface ExpressionVisitor<R> {
    R visitBinaryExpression(BinaryExpression expression);
    R visitLiteralExpression(LiteralExpression expression);
    R visitVariableExpression(VariableExpression expression);
    R visitAssignExpression(AssignExpression expression);
    R visitUnaryExpression(UnaryExpression expression);
    R visitLogicalExpression(LogicalExpression expression);
    R visitCallExpression(CallExpression expression);
    R visitGroupingExpression(GroupingExpression expression);
    R visitThisExpression(ThisExpression expression);
    R visitNewExpression(NewExpression expression);
    R visitPostfixUnary(PostfixUnaryExpression expression);
    R visitInstanceOf(InstanceOfExpression expression);
    R visitSuper(SuperExpression expression);
    R visitLambda(LambdaExpression expression);
}
