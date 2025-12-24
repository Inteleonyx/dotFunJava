package org.dotfun.ast.visitor;

import org.dotfun.ast.statement.*;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */
public interface StatementVisitor<R> {
    R visitLet(LetStatement stmt); //done
    R visitVal(ValStatement stmt);
    R visitGlobal(GlobalStatement stmt);
    R visitExpression(ExpressionStatement stmt);
    R visitIf(IfStatement stmt);
    R visitWhile(WhileStatement stmt);
    R visitFor(ForStatement stmt);
    R visitBreak(BreakStatement stmt);
    R visitContinue(ContinueStatement stmt);
    R visitFunction(FunctionStatement stmt);//done
    R visitReturn(ReturnStatement stmt);
    R visitClass(ClassStatement stmt);
    R visitInterface(InterfaceStatement stmt);//done
    R visitEnum(EnumStatement stmt);
    R visitStruct(StructStatement stmt);
    R visitSwitch(SwitchStatement stmt);
    R visitImport(ImportStatement stmt);
    R visitExport(ExportStatement stmt);
    R visitTry(TryStatement stmt);
    R visitThrow(ThrowStatement stmt);
    R visitBlock(BlockStatement stmt);
    R visitData(DataStatement stmt);
    R visitConstructor(ConstructorStatement stmt);//done
}
