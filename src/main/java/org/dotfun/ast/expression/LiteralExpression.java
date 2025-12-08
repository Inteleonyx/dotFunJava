package org.dotfun.ast.expression;

import org.dotfun.ast.Expression;
import org.dotfun.ast.visitor.ExpressionVisitor;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */

public class LiteralExpression implements Expression {
    public enum Type { NUMBER, STRING, BOOLEAN, NIL }

    public final Type type;
    public final double numberValue;
    public final String stringValue;
    public final boolean boolValue;

    public LiteralExpression(double value) {
        this.type = Type.NUMBER;
        this.numberValue = value;
        this.stringValue = null;
        this.boolValue = false;
    }

    public LiteralExpression(String value) {
        this.type = Type.STRING;
        this.stringValue = value;
        this.numberValue = 0;
        this.boolValue = false;
    }

    public LiteralExpression(boolean value) {
        this.type = Type.BOOLEAN;
        this.boolValue = value;
        this.numberValue = 0;
        this.stringValue = null;
    }

    public LiteralExpression() {  // Nil
        this.type = Type.NIL;
        this.numberValue = 0;
        this.stringValue = null;
        this.boolValue = false;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visitLiteralExpression(this);
    }
}
