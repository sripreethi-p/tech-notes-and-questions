package com.dsa.algorithms.service.sorting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SortingTechniques {

    private final MergeSortAlgorithm mergeSortAlgorithm;

    public SortingTechniques(MergeSortAlgorithm mergeSortAlgorithm) {
        this.mergeSortAlgorithm = mergeSortAlgorithm;
    }


    public void selectionSort(int[] arr) {
        log.info("Initial array: {}", arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) { // condition for stability
                swapElementsAt(arr, i, min_idx);
            }
        }
        log.info("Selection Sorted array: {}", arr);
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        log.info("Initial array: {}", arr);
        int i, j;
        boolean swapped;
        for (i = 0; i < n-1; i++) {
            swapped = false;
            for (j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swapElementsAt(arr, j, j+1);
                    swapped = true;
                }
            }

            if (!swapped) { // optimizing time complexity from O(n^2) to the best of O(n)
                break;
            }
        }
        log.info("Bubble Sorted array: {}", arr);
    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        log.info("Initial array: {}", arr);
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        log.info("Insertion Sorted array: {}", arr);
    }

    public void mergeSort(int[] arr) {
        log.info("Initial array: {}", arr);
        mergeSortAlgorithm.mergeSort(arr);
        log.info("Merge Sorted array: {}", arr);
    }

    private void swapElementsAt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
