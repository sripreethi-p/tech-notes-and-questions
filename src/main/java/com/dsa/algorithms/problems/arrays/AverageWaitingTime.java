package com.dsa.algorithms.problems.arrays;

import org.springframework.stereotype.Component;

@Component
public class AverageWaitingTime {

    /* 1701. Average Waiting Time
    * There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:
    arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
    timei is the time needed to prepare the order of the ith customer.
    When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle.
    The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time.
    The chef prepares food for customers in the order they were given in the input.
    Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
    * */
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double[] waitingTimes = new double[n];

        waitingTimes[0] = customers[0][1];
        double sum = waitingTimes[0];
        for (int i = 1; i < n; i++) {
            if (waitingTimes[i - 1] + customers[i - 1][0] - customers[i][0] > 0) {
                waitingTimes[i] = customers[i - 1][0] + waitingTimes[i - 1] + customers[i][1] - customers[i][0];
            } else {
                waitingTimes[i] = customers[i][1];
            }
            sum += waitingTimes[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(waitingTimes[i]);
        }
        return sum / n;
    }
}
