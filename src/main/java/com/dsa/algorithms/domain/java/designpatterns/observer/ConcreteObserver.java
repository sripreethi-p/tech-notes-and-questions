package com.dsa.algorithms.domain.java.designpatterns.observer;

public class ConcreteObserver implements Observer {

    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " got the Updated state : " + message);
    }
}
