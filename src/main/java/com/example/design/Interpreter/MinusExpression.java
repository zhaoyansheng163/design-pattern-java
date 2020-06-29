package com.example.design.Interpreter;


import java.util.Map;

/**
 * 减法表达式：NonTerminalExpression的具体子类
 * 将表达式左操作数减去右操作数
 */
public class MinusExpression extends MathSymbolExpression {

    public MinusExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpret(Map<String, Integer> varMap) {
        return super.leftExpression.interpret(varMap) - super.rightExpression.interpret(varMap);
    }
}

