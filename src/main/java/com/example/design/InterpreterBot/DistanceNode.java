//designpatterns.interpreter.DistanceNode.java
package com.example.design.InterpreterBot;

//距离解释：终结符表达式
public class DistanceNode extends AbstractNode {
	private String distance;
	
	public DistanceNode(String distance) {
		this.distance = distance;
	}
	
	//距离表达式的解释操作
	public String interpret() {
		return this.distance;
	}	
}