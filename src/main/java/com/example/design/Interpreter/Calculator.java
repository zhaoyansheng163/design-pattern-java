package com.example.design.Interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * 将输入后的表达式每个遍历，并通过对应的Expression进行解释
 * 提供calculate()接口，获取最终Expression的interpret()结果
 */
public class Calculator {

    private String expStr;

    /**
     * 定义表达式
     */
    private AbstractExpression expression;

    public Calculator(String expStr) {
        this.expStr = expStr;
    }

    public void analyse() {

        Stack<AbstractExpression> expStack = new Stack<>();

        AbstractExpression left;
        AbstractExpression right;

        char[] expChar = expStr.toCharArray();
        for (int i = 0; i < expChar.length; i++) {
            char curExpChar = expChar[i];
            switch (curExpChar) {
                case '+':
                    left = expStack.pop();
                    right = new VarExpression(String.valueOf(expChar[++i]));
                    PlusExpression sumExpression = new PlusExpression(left, right);
                    expStack.push(sumExpression);
                    break;
                case '-':
                    left = expStack.pop();
                    right = new VarExpression(String.valueOf(expChar[++i]));
                    MinusExpression diffExpression = new MinusExpression(left, right);
                    expStack.push(diffExpression);
                    break;
                default:
                    expStack.push(new VarExpression(String.valueOf(curExpChar)));
                    break;
            }
        }

        this.expression = expStack.pop();
    }

    public int calculate(Map<String, Integer> varMap) {
        return this.expression.interpret(varMap);
    }
}

