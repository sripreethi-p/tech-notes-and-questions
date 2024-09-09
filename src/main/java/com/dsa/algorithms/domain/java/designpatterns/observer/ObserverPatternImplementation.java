package com.dsa.algorithms.domain.java.designpatterns.observer;

public class ObserverPatternImplementation {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("observer1");
        ConcreteObserver observer2 = new ConcreteObserver("observer2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setState("2nd state");
        subject.setState("3rd state");
    }
}
