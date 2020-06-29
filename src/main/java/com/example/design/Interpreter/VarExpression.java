package com.example.design.Interpreter;

import java.util.Map;

/**
 * 变量表达式：对应TerminalExpression
 * 操作数的封装对象
 */
public class VarExpression extends AbstractExpression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpret(Map<String, Integer> varMap) {
        Integer var = varMap.get(key);
        return var == null ? 0 : var;
    }
}
