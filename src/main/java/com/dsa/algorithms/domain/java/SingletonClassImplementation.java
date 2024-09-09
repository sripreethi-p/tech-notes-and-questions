package com.dsa.algorithms.domain.java;

import com.dsa.algorithms.domain.java.designpatterns.SingletonClass;

public class SingletonClassImplementation {
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println(instance1 == instance2);
        int instance1Ref = System.identityHashCode(instance1);
        int instance2Ref = System.identityHashCode(instance2);
        System.out.println("Instance 1: " + instance1Ref);
        System.out.println("Instance 2: " + instance2Ref);
    }
}
