package com.example.design.memento;

public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMento() {
        return (new Memento(state));
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public void show() {
        System.out.println("state = " + state);
    }

}