package com.dsa.algorithms.service.sorting;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm {

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swapElementsAt(arr, i, j);
            }
        }
        swapElementsAt(arr, i + 1, high);
        return i + 1;
    }

    private void swapElementsAt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
