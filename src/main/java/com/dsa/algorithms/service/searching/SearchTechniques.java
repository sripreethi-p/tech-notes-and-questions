package com.dsa.algorithms.service.searching;

import org.springframework.stereotype.Component;

@Component
public class SearchTechniques {

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public int ternarySearch(int left, int right, int target, int[] arr) {
       if(right >= left) {
           int mid1  = left + (right - left) / 3;
           int mid2  = right - (right - left) / 3;
           if(arr[mid1] == target)      return mid1;
           if(arr[mid2] == target)      return mid2;
           if(target < arr[mid1])       return ternarySearch(left, mid1-1, target, arr);
           else if(target > arr[mid2])  return ternarySearch(mid2+1, right, target, arr);
           else                         return ternarySearch(mid1+1, mid2-1, target, arr);
       }
       return -1;
    }
}
