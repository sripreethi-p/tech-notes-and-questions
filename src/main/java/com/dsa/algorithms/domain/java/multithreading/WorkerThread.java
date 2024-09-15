package com.dsa.algorithms.domain.java.multithreading;

import java.util.concurrent.CountDownLatch;

public class WorkerThread implements Runnable{
    private String workerName;
    private CountDownLatch countDownLatch;

    public WorkerThread(String workerName, CountDownLatch countDownLatch) {
        this.workerName = workerName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            // Simulate some work with Thread.sleep()
            System.out.println(workerName + " is doing some work...");
            Thread.sleep((long) (Math.random() * 3000));  // Simulate work time
            System.out.println(workerName + " has finished work.");

            // Decrement the count of the latch
            countDownLatch.countDown(); // Signals that this worker is done
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
