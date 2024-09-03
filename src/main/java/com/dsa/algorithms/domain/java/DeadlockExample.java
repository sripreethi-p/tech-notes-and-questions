package com.dsa.algorithms.domain.java;

public class DeadlockExample {

    public void deadlockExample() {
        final Object resource1 = "Resource1";
        final Object resource2 = "Resource2";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource1);

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " waiting to lock " + resource2);

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2);

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " waiting to lock " + resource1);

                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource1);
                }

            }
        });

        thread1.start();
        thread2.start();
    }
}
