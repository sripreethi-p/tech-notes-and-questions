package com.dsa.algorithms.domain.java.locking;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockingMechanisms {
    private static final String ticket = "TICKET";

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static void accessResourceThroughReentrantLocking() {
        try {
            reentrantLock.lock();
            System.out.println("Locked the resource for " + Thread.currentThread().getName());
            System.out.println(ticket + " is available to " + Thread.currentThread().getName());
        } finally {
            reentrantLock.unlock();
            System.out.println("Unlocked the resource for " + Thread.currentThread().getName());
        }
    }

    private static void viewTicketThroughReadWriteLocking() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Locked the ticket to view for " + Thread.currentThread().getName());
            System.out.println(ticket + " is available to view for " + Thread.currentThread().getName());
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("Unlocked the ticket to view for " + Thread.currentThread().getName());
        }
    }

    private static void bookTicketThroughReadWriteLocking() {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Locked the ticket to book for " + Thread.currentThread().getName());
            System.out.println(ticket + " is available to book for " + Thread.currentThread().getName());
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Unlocked the ticket to book for " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        Thread t1a = new Thread(LockingMechanisms::accessResourceThroughReentrantLocking, "thread 1");
        t1a.start();
        Thread t2a = new Thread(LockingMechanisms::accessResourceThroughReentrantLocking, "thread 2");
        t2a.start();
        Thread t3a = new Thread(LockingMechanisms::accessResourceThroughReentrantLocking, "thread 3");
        t3a.start();
        Thread t4a = new Thread(LockingMechanisms::accessResourceThroughReentrantLocking, "thread 4");
        t4a.start();


        Thread t1b = new Thread(LockingMechanisms::viewTicketThroughReadWriteLocking, "thread 1");
        t1b.start();
        Thread t2b = new Thread(LockingMechanisms::viewTicketThroughReadWriteLocking, "thread 2");
        t2b.start();
        Thread t3b = new Thread(LockingMechanisms::bookTicketThroughReadWriteLocking, "thread 3");
        t3b.start();
        Thread t4b = new Thread(LockingMechanisms::bookTicketThroughReadWriteLocking, "thread 4");
        t4b.start();
    }
}
