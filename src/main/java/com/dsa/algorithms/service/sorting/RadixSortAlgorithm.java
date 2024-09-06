package com.dsa.algorithms.service.sorting;

public class RadixSortAlgorithm {

    public void radixSort(int[] array) {
        int maxValue = getMaxValue(array);
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            // starting from unit place for STABILITY
            countSort(array, array.length, exp);
        }

    }

    private int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    private void countSort(int[] array, int n, int exp) {
        int i;
        int[] output = new int[n];
        int[] count = new int[10];

        for (i = 0; i < 10; i++) {
            count[i] = 0;
        }

        for (i = 0; i < n; i++) {
            count[array[i] / exp]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n-1; i >=0; i--) {
            output[count[array[i] / exp] - 1] = array[i];
            count[array[i] / exp]--;
        }

        for (i = 0; i < n; i++) {
            array[i] = output[i];
        }

    }
}
