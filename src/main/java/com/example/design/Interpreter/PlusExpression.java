package com.example.design.Interpreter;

import java.util.Map;

/**
 * 加法表达式：NonTerminalExpression的具体子类
 * 将表达式左和右操作数进行+操作
 */
public class PlusExpression extends MathSymbolExpression {

    public PlusExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpret(Map<String, Integer> var) {
        return super.leftExpression.interpret(var) + super.rightExpression.interpret(var);
    }
}

