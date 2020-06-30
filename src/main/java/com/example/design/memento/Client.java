package com.example.design.memento;

public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("On");    //Originator初始状态
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMento());

        originator.setState("Off");    //Originator状态变为Off
        originator.show();

        originator.setMemento(caretaker.getMemento());    //回复初始状态
        originator.show();
    }

}