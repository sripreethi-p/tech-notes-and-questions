package com.dsa.algorithms.domain.java;

public class JavaBackgroundThreadExample extends Thread{
    public static void main(String[] args) {
        // Create a user thread
        Thread userThread = new UserThread();
        userThread.setName("UserThread");

        // Create a daemon thread
        Thread daemonThread = new DaemonThread();
        daemonThread.setName("DaemonThread");
        daemonThread.setDaemon(true); // Set this thread as a daemon thread

        // Start both threads
        daemonThread.start();
        userThread.start();

        // Main thread finishes here
        System.out.println("Main thread finished.");
    }
}

