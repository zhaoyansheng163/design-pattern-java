package com.example.design.Interpreter;


import java.util.HashMap;

/**
 * 客户端
 * 给定待计算表达式、各个变量的值
 */
//https://blog.csdn.net/Keiissland/article/details/104900609
//源码：https://github.com/zhaoyansheng163/design-pattern-java/tree/master/src/main/java/com/example/design/Interpreter
public class Client {

    public static void main(String[] args) {

        // 1. 给定待计算表达式文法
        String expStr = "a+b+c-d+e";

        // 2. 给待计算表达式文法变量输入值
        HashMap<String, Integer> varMap = new HashMap<>();
        varMap.put("a", 1);
        varMap.put("b", 2);
        varMap.put("c", 3);
        varMap.put("d", 4);
        varMap.put("e", 5);

        // 3. 文法解析
        Calculator calculator = new Calculator(expStr);
        calculator.analyse();

        // 4. 计算并打印
        System.out.println(calculator.calculate(varMap));
    }
}
