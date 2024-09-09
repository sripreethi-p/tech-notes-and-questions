package com.dsa.algorithms.domain.java.multithreading;

public class VolatileExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Thread 1 will update the flag
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 setting flag to true");
            sharedData.setFlag(true);
        });

        // Thread 2 will check the flag
        Thread thread2 = new Thread(() -> {
            while (!sharedData.getFlag()) {
                // Busy-waiting until flag becomes true
            }
            System.out.println("Thread 2 detected flag change");
        });

        thread1.start();
        thread2.start();
    }
}
