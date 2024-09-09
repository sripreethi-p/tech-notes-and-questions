package com.dsa.algorithms.domain.java;

public class StaticClassImpementation {
    public static void main(String[] args) {
        SomeClass.StaticClass obj1 = SomeClass.StaticClass.getInstance();
        SomeClass.StaticClass obj2 = SomeClass.StaticClass.getInstance();

        int add1 = System.identityHashCode(obj1);
        int add2 = System.identityHashCode(obj2);

        obj1.print();
        obj2.print();

        System.out.println(add1);
        System.out.println(add2);

    }
}
