package com.dsa.algorithms.service.sorting;

public class HeapSortAlgorithm {

    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            // heapifying only from the last parent node
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            // swapping the largest element on top with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

    }


    private void heapify(int[] arr, int N, int i) {
        int largest = i;

        // indices of ith node's children
        int l = 2*i+1;
        int r = 2*i+2;

        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            // swapping if the root is smaller than the children
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }

        heapify(arr, N, largest);
    }
}
