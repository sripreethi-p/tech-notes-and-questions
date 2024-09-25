# Backtracking

## Definition
A problem solving technique with a depth-first search algo used to find solution incrementally by trying out different options and undoing them if they lead to a dead end. When a dead end is reached, the algorithm backtracks to the previous decision point and exploresa different path until a solution is found or all the options have been exhausted.  

Used for situations where you need to explore multiple possibilities to solve a problem like - searching for a path in a maze, solving a sudoku.

### Types
1. Decision Problems (is there a way)
2. Optimization Problems (best way)
3. Enumeration Problems (no.of ways)

## Determining a backtracking problem
Generally, every constraint satisfaction problem can be solved using backtracking, but Is it optimal to use backtracking every time?   
Turns out NO, there are a vast number of problems that can be solved using **Greedy** or **Dynamic programming** in logarithmic or polynomial time complexity which is far better than exponential complexity of Backtracking. However many problems still exists that can only be solved using Backtracking.

### Example
- Say there are 3 boxes out of which 2 are empty and 1 has a gold coin. You need to find the gold coin.    

**DP fails here** because opening/closing one box does not affect the other box's outcome. No property of _overlapping subproblems_.   
**Greedy approach fails here** because it chooses local maxima to get the global maxima. Here, all boxes have equal probability of having the coin. So, _no criteria to decide a local maxima_ at all.  
**Backtracking works** because it is simply brute forcing every route. We choose one box each time and close it back if it doesn't have the coin which acts as the BACKTRACKING step.

## Time Complexity
Since it is a plain brute force approach, the time complexity is usually `exponential  : O ( K^N ) or factorial : O ( N! )`


## Problems
1. N-Queen Problem
2. Solve a Sudoku
3. M-coloring problem
4. Rat in a maze
5. The Knight's tour problem
6. Permutation of a given String

### The Knight's Tour Problem

#### Problem Statement
Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited.

#### Solution

- The Naive Algorithm is to generate all tours one by one and check if the generated tour satisfies the constraints.  
- Backtracking works in an incremental way to attack problems. Typically, we start from an empty solution vector and one by one add items (Meaning of item varies from problem to problem. In the context of Knight’s tour problem, an item is a Knight’s move). When we add an item, we check if adding the current item violates the problem constraint, if it does then we remove the item and try other alternatives. If none of the alternatives works out then we go to the previous stage and remove the item added in the previous stage. If we reach the initial stage back then we say that no solution exists. If adding an item doesn’t violate constraints then we recursively add items one by one. If the solution vector becomes complete then we print the solution.
- Code is [here](../../../../src/main/java/com/dsa/algorithms/problems/backtracking/KnightsTourProblem.java)


