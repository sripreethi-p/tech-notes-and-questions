# Problem Solving Techniques

1. [Dynamic Programming (DP)](#1-dynamic-programming-dp)
2. [Backtracking](#2-backtracking)
3. [Greedy Approach](#3-greedy-approach)
4. [Divide and Conquer](#4-divide-and-conquer)
5. Branch and Bound
6. Recursion
7. Memoization
8. Exhaustive Search / Brute Force
9. [Two-Pointer Technique](#9-two-pointer-technique)
10. Sliding Window Technique
11. Binary Search
12. Hashing
13. Union-Find (Disjoint Set Union)
14. Priority Queue / Heaps
15. Mathematical Techniques
16. Graph Algorithms
17. Bit Manipulation
18. Heuristic Methods
19. Exhaustive Search / Brute Force
20. Simulation



## [1. Dynamic Programming (DP)](dynamicprogramming.md)

### When to use:

- **Optimal Substructure:** The problem can be broken down into overlapping subproblems.
- **Overlapping Subproblems:** The same subproblem is solved multiple times. DP helps store these results to avoid redundant computations.
- **Optimized Solution:** Problems with constraints like “find the maximum,” “find the minimum,” or “count the number of ways.”

### How it works:

- Break down the problem into smaller, simpler subproblems.
- Store the results of these subproblems to avoid recomputation.
- Build the solution to the main problem using the solutions of the subproblems (usually via **bottom-up or top-down memoization**).

### Examples:

* Fibonacci numbers
* Knapsack problem
* Longest Common Subsequence
* Shortest path algorithms (e.g., Dijkstra’s, Floyd-Warshall)

### Key Characteristics:

* Uses a table (2D array or similar) to store intermediate results.
* Generally involves recursion with memoization or an iterative bottom-up approach.


<br></br>


## [2. Backtracking](backtracking.md)

### When to use:

* Problems that require exploring all possible configurations and need to find one or all solutions.
* Typically used for constraint satisfaction problems.
* If the problem involves permutations, combinations, or subset generation, backtracking is a good choice.

### How it works:

* Recursively try out all possibilities.
* If a partial solution is invalid, abandon it (prune it) and backtrack to a previous state.
* Often used when constructing a solution step by step.

### Examples:

* N-Queens problem
* Sudoku solver
* Subset sum problem
* Solving mazes

### Key Characteristics:

* Involves depth-first search (DFS) to explore possibilities.
* It’s a brute-force method, but you can prune paths that don’t lead to a valid solution (backtracking helps in pruning).

<br></br>


## [3. Greedy Approach](greedyapproach.md)

### When to use:

* Problems where a **locally optimal choice** at each step leads to a globally optimal solution.
* Problems that involve making a series of choices, each of which looks best at that moment.
* Typically applied to optimization problems.

### How it works:

* Make the best (greedy) choice at each step.
* After every choice, reduce the problem to a smaller one, and repeat.
* It doesn’t always guarantee the optimal solution, but in some specific problems (with the **greedy-choice property**), it works perfectly.

### Examples:

* Huffman encoding
* Kruskal’s and Prim’s algorithms (minimum spanning tree)
* Fractional knapsack problem
* Activity selection problem

### Key Characteristics:

* Focuses on local optimization (i.e., best choice at each step).
* Faster and simpler than dynamic programming but does not always guarantee an optimal solution.


<br></br>

## 4. Divide and Conquer

### When to use:

* When a problem can be broken down into two or more smaller subproblems that can be solved independently.
* The problem must exhibit the divide and merge property.

### How it works:

* Divide the problem into subproblems of the same type.
* Solve the subproblems recursively.
* Combine the solutions of the subproblems to form the solution to the original problem.

### Examples:

* Merge Sort
* Quick Sort
* Binary Search
* Matrix multiplication (Strassen’s algorithm)

### Key Characteristics:

* Splits a problem into smaller instances and then merges the results.
* Recursive approach.



<br></br>




## 9. Two-Pointer Technique

### When to use:

Useful for problems involving arrays or linked lists where you need to find pairs, 
triplets, or subarrays with specific properties.

### How it works:

* Use two pointers, typically starting at different ends of a data structure (e.g., an array).
* Move the pointers towards each other based on the problem's logic until you find the solution.

### Examples:

* Finding pairs that sum up to a target in a sorted array.
* Reversing an array or linked list.
* Merging two sorted arrays.

### Key Points:

* Efficient for problems with sorted arrays or lists.
* Reduces time complexity from O(n²) to O(n) in many cases.


## 10. Sliding Window Technique

### When to use:

When dealing with contiguous subarrays or substrings in problems related to sums, 
averages, or specific properties of the window.

### How it works:

* Define a window of fixed or variable size that "slides" across the data structure.
* Adjust the window size or position based on the problem's requirements while keeping track of the required information.

### Examples:

* Maximum sum of a subarray of size k.
* Longest substring with distinct characters.
* Finding all anagrams in a string.