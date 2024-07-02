## Sorting Techniques
### Terminology
1. **Stability** : Elements of same value retain their original positions.  
2. **In-place** : Uses constant space for producing the output (modifies the given array only).  
3. **Internal** : All data is placed in the main memory or internal memory. The problem cannot take input beyond its size.

### 1. Selection Sort
Repeatedly select the lowest/highest element from the unsorted part of the list & place it after the sorted part of the list.  
![Selection Sort](images/selectionsort.png)  
**Time Complexity:** O(n^2) in all cases  
**Space Complexity:** O(1)  
❌ Stable (default) (can me made stable)  
✔️ In-place  
✔️ Internal

### 2. Bubble Sort
Repeatedly swap the adjacent elements if they're in the wrong order, bringing the highest element to the end in each iteration.  
![Bubble Sort](images/bubblesort.png)  
**Time Complexity:** O(n^2) in worst & avg, O(n) in best cases (already sorted)  
**Space Complexity:** O(1)  
✔️ Stable  
✔️ In-place  
✔️ Internal

### 3. Insertion Sort
Iteratively insert each element of an unsorted list into its correct position in the sorted portion of the list.        
![Insertion Sort](images/insertionsort.png)  
**Time Complexity:** O(n^2) in worst & avg, O(n) in best cases (already sorted)  
**Space Complexity:** O(1)  
✔️ Stable  
✔️ In-place  
✔️ Internal

### 4. Merge Sort
Recursively divide the input into smaller sub-arrays and sort those & merge them back by Divide & Conquer approach.  
![Merge Sort](images/mergesort.png)  
This one of the most optimised & most used sorting algos.  
**Time Complexity:** O(n logn)  
**Space Complexity:** O(n)  
✔️ Stable  
❌ In-place  
❌ Internal

### 5. Quick Sort
Recursively pick an element as pivot and partition the array around it by placing the pivot in its correct position in the sorted array by Divide & Conquer aproach.    
![Quick Sort](images/quicksort.png)   
**Time Complexity:** O(n logn) in best cases, O(n^2) is worst & avg (poor choice of pivot)   
**Space Complexity:** O(1) excluding stack space  
✔️ Stable  
✔️ In-place  
✔️ Internal  

### 6. Heap Sort
