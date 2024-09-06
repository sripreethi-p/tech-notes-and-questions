package com.dsa.algorithms.domain.java;

public class CustomThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Entered Custom Thread implementing Runnable's run method");
    }
}
