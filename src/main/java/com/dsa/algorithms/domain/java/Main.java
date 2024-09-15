package com.dsa.algorithms.domain.java;

public class Main {

    NonStaticOuterClass.NestedClass nestedClass = new NonStaticOuterClass.NestedClass();

    public void accessStaticClassMethods() {
        nestedClass.printNonStaticMethod();
        System.out.println(nestedClass.NON_STATIC_FIELD);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.accessStaticClassMethods();
    }
}
