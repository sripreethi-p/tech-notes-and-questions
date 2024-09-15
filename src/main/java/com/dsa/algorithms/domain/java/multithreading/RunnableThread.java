package com.dsa.algorithms.domain.java.multithreading;

public class RunnableThread implements Runnable {
    private String threadName;
    public RunnableThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
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
