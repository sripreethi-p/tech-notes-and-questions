package com.dsa.algorithms.domain.java.multithreading;

public class Main {
    public static void main(String[] args) {
        // Create instances of Runnable
        RunnableThread task1 = new RunnableThread("Thread-1");
        RunnableThread task2 = new RunnableThread("Thread-2");
        RunnableThread task3 = new RunnableThread("Thread-3");

        // Create instances of ExtendedThread
        ExtendedThread extendedThread1 = new ExtendedThread("Thread-1");
        ExtendedThread extendedThread2 = new ExtendedThread("Thread-2");
        ExtendedThread extendedThread3 = new ExtendedThread("Thread-3");

        // Create threads with the Runnable tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start the threads
//        thread1.start();
//        thread2.start();
//        thread3.start();

        // Start the extended threads
        extendedThread1.start();
        extendedThread2.start();
        extendedThread3.start();


    }
}
