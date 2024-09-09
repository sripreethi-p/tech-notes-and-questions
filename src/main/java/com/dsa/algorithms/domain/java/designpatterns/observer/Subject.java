package com.dsa.algorithms.domain.java.designpatterns.observer;


public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
