package com.dsa.algorithms.domain.java;

public class NonStaticOuterClass {

    public static class NestedClass {
        public static String STATIC_FIELD = "STATIC_FIELD";
        public String NON_STATIC_FIELD = "NON_STATIC_FIELD";

        public static void printStaticMethod() {
            System.out.println("this is a static method");
        }

        public void printNonStaticMethod() {
            System.out.println("this is a non static method");
        }


    }
}
