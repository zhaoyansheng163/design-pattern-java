package com.example.design.memento;

//备忘录模式
public class CarCaretaker {

	public static void main(String s[]) {
		new CarCaretaker().runMechanicTest();
	}

	public void runMechanicTest() {
		CarOriginator.Memento savedState = new CarOriginator.Memento("");
		CarOriginator originator = new CarOriginator();
		originator.setState("State1");
		originator.setState("State2");
		savedState = originator.saveState();
		originator.setState("State3");

		originator.restoreState(savedState);
		System.out.println("final state:" + originator.getState());
	}

}
