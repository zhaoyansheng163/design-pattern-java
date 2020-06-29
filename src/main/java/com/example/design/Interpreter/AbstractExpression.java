package com.example.design.Interpreter;

import java.util.Map;

/**
 * 抽象表达式，对应AbstractExpression角色
 * 抽象语法树节点的抽象，每个节点有自己的解释操作interpret()
 */
public abstract class AbstractExpression {
    public abstract int interpret(Map<String, Integer> varMap);
}
