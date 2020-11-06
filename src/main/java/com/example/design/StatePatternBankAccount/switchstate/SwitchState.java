//designpatterns.state.switchstate.SwitchState.java
package com.example.design.StatePatternBankAccount.switchstate;

public abstract class SwitchState {
	public abstract void on(Switch s);
	public abstract void off(Switch s);
}
