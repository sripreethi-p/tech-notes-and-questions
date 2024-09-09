package com.dsa.algorithms.domain.java;

public class AnimalImplementation {
    public static void main (String[] args) {
        Animal lion = new Animal("Lion");
        Animal nothing = new Animal();

        System.out.println(lion.getName());
        System.out.println(nothing.getName());

    }
}
