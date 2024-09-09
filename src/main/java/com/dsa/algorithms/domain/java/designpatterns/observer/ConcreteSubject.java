package com.dsa.algorithms.domain.java.designpatterns.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    @Getter
    private String state;
    private List<Observer> observers = new ArrayList<>();

    public ConcreteSubject() {
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
