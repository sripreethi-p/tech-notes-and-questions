package com.dsa.algorithms.domain.java.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start three worker threads
        for (int i = 1; i <= 3; i++) {
            Thread worker = new Thread(new WorkerThread("Worker-" + i, latch));
            worker.start();
        }

        // Main thread will wait for all workers to finish
        try {
            System.out.println("Main thread is waiting for workers to finish...");
            latch.await();  // Blocks until the count reaches zero
            System.out.println("All workers have finished. Main thread can proceed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
