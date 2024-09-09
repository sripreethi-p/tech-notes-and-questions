package com.dsa.algorithms.domain.java.multithreading;

public class SharedData {
    // Declare the variable as volatile
    private volatile boolean flag = false;

    public void setFlag(boolean value) {
        flag = value;
    }

    public boolean getFlag() {
        return flag;
    }
}
