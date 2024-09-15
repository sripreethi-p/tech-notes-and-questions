package com.dsa.algorithms.domain.java.designpatterns.singleton;

public class SingletonClass {

    private static SingletonClass instance;

    private SingletonClass() {
        // private constructor to prevent instantiation
    }

    /* synchronized - when multiple threads reach this method, they could create multiple instances.
    'synchronized' avoid that and ensures thread safety by making sure only one thread is able to execute the method */

    // the null check (instance == null) ensures that the instance is created only if it's not created before

    public static synchronized SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}

class SingletonClassUsage {
    public static void main(String[] args) {
        SingletonClass singleton1 = SingletonClass.getInstance();
        SingletonClass singleton2 = SingletonClass.getInstance();

        System.out.println(singleton1 == singleton2); // true, same instance
    }
}
