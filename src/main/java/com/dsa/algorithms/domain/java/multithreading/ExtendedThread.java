package com.dsa.algorithms.domain.java.multithreading;

public class ExtendedThread extends Thread{

    public ExtendedThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " - iteration : " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted");
            }
        }
    }
}
