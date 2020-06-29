package com.example.design.Interpreter;

import java.util.Map;

/**
 * 操作符的父类，对应NonTerminalExpression
 */
public class MathSymbolExpression extends AbstractExpression {

    /**
     * 左操作数表达式
     */
    protected AbstractExpression leftExpression;

    /**
     * 右操作数表达式
     */
    protected AbstractExpression rightExpression;

    public MathSymbolExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    /**
     * 空实现，具体的实现，交给具体的符号表达式实现
     * @param varMap 变量Map
     * @return 表达式计算后的结果
     */
    @Override
    public int interpret(Map<String, Integer> varMap) {
        return 0;
    }
}
