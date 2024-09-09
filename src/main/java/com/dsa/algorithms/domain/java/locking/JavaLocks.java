package com.dsa.algorithms.domain.java.locking;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JavaLocks {
    private int counter = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void incrementUsingReentrantLock() {
        reentrantLock.lock();
        try {
            counter++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void incrementUsingReadWriteLock() {
        readWriteLock.writeLock().lock();
        try {
            counter++;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int getCountUsingReentrantLock() {
        reentrantLock.lock();
        try {
            return counter;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getCountUsingReadWriteLock() {
        readWriteLock.readLock().lock();
        try {
            return counter;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
